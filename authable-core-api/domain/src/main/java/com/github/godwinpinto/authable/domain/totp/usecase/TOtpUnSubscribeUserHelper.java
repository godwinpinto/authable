package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUnSubscribeUserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TOtpUnSubscribeUserHelper {

  TOtpUserMasterSPI tOtpUserMasterSPI;

  TOtpUnSubscribeUserHelper(TOtpUserMasterSPI tOtpUserMasterSPI) {
    this.tOtpUserMasterSPI = tOtpUserMasterSPI;
  }

  private static Mono<TOtpUnSubscribeUserDto> formatSuccessMessage() {
    return Mono.just(
        TOtpUnSubscribeUserDto.builder()
            .statusCode("200")
            .statusDescription("TOTP subscription cancelled for user")
            .build());
  }

  Mono<TOtpUserMasterDto> isUserDisabledOrNonActive(TOtpUserMasterDto user) {
    if (user.getStatus().equals(ApplicationConstants.RecordStatus.INACTIVE.getValue())) {
      return Mono.error(new NonFatalException("200", "You have already Unsubscribed from TOTP"));
    } else if (user.getStatus().equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
      return Mono.just(user);
    } else {
      return Mono.error(
          new NonFatalException(
              "405", "Your TOTP is blocked. Please contact administrator to unblock."));
    }
  }

  public Mono<TOtpUnSubscribeUserDto> updateDbToUnsubscribe(String userSystemId) {
    return tOtpUserMasterSPI
        .removeDisabledStatus(
            userSystemId,
            DateTimeUtils.getCurrentLocalDateTime(),
            ApplicationConstants.RecordStatus.INACTIVE.getValue())
        .flatMap(
            status ->
                status == 1L
                    ? formatSuccessMessage()
                    : Mono.error(new NonFatalException("500", "Failure in updating")))
        .switchIfEmpty(Mono.error(new NonFatalException("500", "Failure in updating")));
  }

  public Mono<TOtpUnSubscribeUserDto> formatNoRecordFoundMessage() {
    return Mono.just(
        TOtpUnSubscribeUserDto.builder()
            .statusCode("404")
            .statusDescription("No active subscription found for user")
            .build());
  }

  public Mono<TOtpUnSubscribeUserDto> fallbackMethod(Throwable error) {
    if (error instanceof NonFatalException nfe) {
      return Mono.just(
          TOtpUnSubscribeUserDto.builder()
              .statusCode(nfe.getErrCode())
              .statusDescription(error.getMessage())
              .build());
    } else {
      return Mono.just(
          TOtpUnSubscribeUserDto.builder()
              .statusCode("500")
              .statusDescription("Unknown error occurred")
              .build());
    }
  }
}
