package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpVerifyDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TOtpVerifyHelper {

  TOtpUserMasterSPI tOtpUserMasterSPI;
  TOtpCryptoSPI tOtpCryptoSPI;

  @Value("${domain.totp.max-failed-login-attempts}")
  private int maxFailedAttempts;

  TOtpVerifyHelper(TOtpUserMasterSPI tOtpUserMasterSPI, TOtpCryptoSPI tOtpCryptoSPI) {
    this.tOtpUserMasterSPI = tOtpUserMasterSPI;
    this.tOtpCryptoSPI = tOtpCryptoSPI;
  }

  Mono<TOtpUserMasterDto> isUserNotActive(TOtpUserMasterDto user) {
    if (user.getStatus().equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
      return Mono.just(user);
    } else {
      return Mono.error(
          new NonFatalException("300", "Access is inactive or disabled for the user"));
    }
  }

  public Mono<TOtpVerifyDto> formatNoSubscriptionMessage() {
    return Mono.just(
        TOtpVerifyDto.builder()
            .statusCode("300")
            .statusDescription("No active subscription found for user")
            .build());
  }

  public Mono<TOtpVerifyDto> fallbackMethod(Throwable error) {
    if (error instanceof NonFatalException) {
      return Mono.just(
          TOtpVerifyDto.builder()
              .statusCode(((NonFatalException) error).getErrCode())
              .statusDescription(error.getMessage())
              .build());
    } else {
      return Mono.just(
          TOtpVerifyDto.builder()
              .statusCode("500")
              .statusDescription("Unknown error occurred")
              .build());
    }
  }

  public Mono<TOtpVerifyDto> verifyAndUpdateOtp(
      String otp, String userSystemId, TOtpUserMasterDto user) {
    if (!tOtpCryptoSPI.verify(otp, userSystemId, user.getUserSecret())) {
      return processInvalidAttempt(userSystemId, user);
    } else {
      return processSuccessAttempt(userSystemId);
    }
  }

  private Mono<TOtpVerifyDto> processSuccessAttempt(String userSystemId) {
    return tOtpUserMasterSPI
        .updateLoginSuccess(userSystemId, DateTimeUtils.getCurrentLocalDateTime())
        .flatMap(this::formatDbSuccessUpdateResponse);
  }

  private Mono<TOtpVerifyDto> formatDbSuccessUpdateResponse(Long l) {
    if (l == 1L) {
      return Mono.just(
          TOtpVerifyDto.builder()
              .statusCode("200")
              .statusDescription("Verification successful")
              .build());
    } else {
      return Mono.error(new NonFatalException("300", "Error in updating database"));
    }
  }

  private Mono<TOtpVerifyDto> processInvalidAttempt(String userSystemId, TOtpUserMasterDto user) {
    short attemptsCount = user.getNoOfAttempts();
    attemptsCount++;
    user.setNoOfAttempts(attemptsCount);
    return tOtpUserMasterSPI
        .updateInvalidAttempt(
            userSystemId, user.getNoOfAttempts(), DateTimeUtils.getCurrentLocalDateTime())
        .flatMap(x -> disableIfAttemptsExceeded(userSystemId, user));
  }

  private Mono<TOtpVerifyDto> disableIfAttemptsExceeded(
      String userSystemId, TOtpUserMasterDto user) {
    if (user.getNoOfAttempts() >= maxFailedAttempts) {
      return tOtpUserMasterSPI
          .updateDisable(
              userSystemId,
              DateTimeUtils.getCurrentLocalDateTime(),
              ApplicationConstants.RecordStatus.DISABLED.getValue())
          .flatMap(
              x1 -> {
                return Mono.error(new NonFatalException("500", "Account has been locked"));
              });
    } else {
      return Mono.error(new NonFatalException("300", "Invalid OTP. Please try again."));
    }
  }
}
