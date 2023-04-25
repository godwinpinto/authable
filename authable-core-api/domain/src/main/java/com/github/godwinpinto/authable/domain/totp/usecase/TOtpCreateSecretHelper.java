package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpCreateNewDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TOtpCreateSecretHelper {

  private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error. Contact Administrator.";
  private final FetchPrincipalComponent fetchPrincipalComponent;
  TOtpUserMasterSPI tOtpUserMasterSPI;
  TOtpCryptoSPI tOtpCryptoSPI;

  TOtpCreateSecretHelper(
      TOtpUserMasterSPI tOtpUserMasterSPI,
      TOtpCryptoSPI tOtpCryptoSPI,
      FetchPrincipalComponent fetchPrincipalComponent) {
    this.tOtpUserMasterSPI = tOtpUserMasterSPI;
    this.tOtpCryptoSPI = tOtpCryptoSPI;
    this.fetchPrincipalComponent = fetchPrincipalComponent;
  }

  Mono<TOtpUserMasterDto> isAllowedToReset(TOtpUserMasterDto user) {
    if (user.getStatus().equals(ApplicationConstants.RecordStatus.DISABLED.getValue())) {
      return Mono.error(
          new NonFatalException("300", "Your TOTP is disabled. Contact administrator"));
    } else if (user.getStatus().equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
      return Mono.error(
          new NonFatalException(
              "300",
              "You already have an active TOTP. "
                  + "Unsubscribe first to generate new one or contact administrator"));
    } else if (user.getStatus().equals(ApplicationConstants.RecordStatus.INACTIVE.getValue())) {
      return Mono.just(user);
    } else {
      return Mono.error(new NonFatalException("300", UNKNOWN_ERROR_MESSAGE));
    }
  }

  public Mono<TOtpCreateNewDto> updateDbToReset(String userSystemId, TOtpUserMasterDto user) {
    user.setModificationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    user.setModificationId(userSystemId);
    user.setCreationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    user.setCreationId(userSystemId);
    user.setInvalidAttemptDateTime(null);
    user.setLastLoginDateTime(null);
    user.setLockedDateTime(null);
    user.setStatus(ApplicationConstants.RecordStatus.ACTIVE.getValue());
    user.setNoOfAttempts((short) 0);
    user.setUserSecret(tOtpCryptoSPI.generateSecretKey(userSystemId));
    return tOtpUserMasterSPI
        .updateEntity(user)
        .flatMap(
            updateCount -> {
              if (updateCount == 1) {
                return formatSuccessResponse(userSystemId, user);
              } else {
                return Mono.error(new NonFatalException("300", UNKNOWN_ERROR_MESSAGE));
              }
            });
  }

  public Mono<TOtpCreateNewDto> createNewRecord(String systemId, String userSystemId) {
    return fetchPrincipalComponent
        .getAuthDetails()
        .flatMap(userDto -> createUserDto(systemId, userSystemId, userDto))
        .flatMap(user1 -> createRecordInDb(userSystemId, user1))
        .switchIfEmpty(Mono.error(new NonFatalException("500", "Unable to fetch login details")));
  }

  private Mono<TOtpCreateNewDto> createRecordInDb(String userSystemId, TOtpUserMasterDto user1) {
    return tOtpUserMasterSPI
        .createEntity(user1)
        .flatMap(
            status -> {
              if (Boolean.TRUE.equals(status)) {
                return formatSuccessResponse(userSystemId, user1);
              } else {
                return Mono.error(new NonFatalException("300", UNKNOWN_ERROR_MESSAGE));
              }
            })
        .switchIfEmpty(Mono.error(new NonFatalException("300", UNKNOWN_ERROR_MESSAGE)));
  }

  private Mono<TOtpCreateNewDto> formatSuccessResponse(
      String userSystemId, TOtpUserMasterDto user1) {
    return Mono.just(
        TOtpCreateNewDto.builder()
            .statusCode("200")
            .statusDescription("TOTP generated successfully.")
            .secretKey(tOtpCryptoSPI.getPlainTextSecret(userSystemId, user1.getUserSecret()))
            .build());
  }

  private Mono<TOtpUserMasterDto> createUserDto(
      String systemId, String userSystemId, UserDto userDto) {
    String secret = tOtpCryptoSPI.generateSecretKey(userSystemId);
    TOtpUserMasterDto user1 =
        TOtpUserMasterDto.builder()
            .userSecret(secret)
            .userId(userSystemId)
            .accessType("B")
            .systemId(systemId)
            .status(ApplicationConstants.RecordStatus.ACTIVE.getValue())
            .creationId(userDto.getUsername())
            .modificationId(userDto.getUsername())
            .noOfAttempts((short) 0)
            .build();
    return Mono.just(user1);
  }

  public Mono<TOtpCreateNewDto> fallbackMethod(Throwable error) {
    if (error instanceof NonFatalException e) {
      return Mono.just(
          TOtpCreateNewDto.builder()
              .statusCode(e.getErrCode())
              .statusDescription(e.getMessage())
              .build());
    } else {
      return Mono.just(
          TOtpCreateNewDto.builder()
              .statusCode("500")
              .statusDescription("Unknown error occurred")
              .build());
    }
  }
}
