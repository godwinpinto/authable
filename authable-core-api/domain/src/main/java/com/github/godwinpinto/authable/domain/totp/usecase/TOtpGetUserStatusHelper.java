package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserStatusDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TOtpGetUserStatusHelper {

  Mono<TOtpUserStatusDto> userStatusFromDatabase(TOtpUserMasterDto user) {

    if (user.getStatus().equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
      return Mono.just(
          TOtpUserStatusDto.builder()
              .statusCode("200")
              .statusDescription("User is Subscribed for TOTP.")
              .build());
    } else if (user.getStatus().equals(ApplicationConstants.RecordStatus.INACTIVE.getValue())) {
      return Mono.just(
          TOtpUserStatusDto.builder()
              .statusCode("404")
              .statusDescription("No Active Subscription for the user")
              .build());
    } else {
      return Mono.just(
          TOtpUserStatusDto.builder()
              .statusCode("405")
              .statusDescription("User is Blocked for TOTP.")
              .build());
    }
  }

  Mono<TOtpUserStatusDto> recordNotFound() {
    return Mono.just(
        TOtpUserStatusDto.builder()
            .statusCode("404")
            .statusDescription("No Active Subscription")
            .build());
  }
}
