package com.github.godwinpinto.authable.domain.totp.ports.spi;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface TOtpUserMasterSPI {
    Mono<Long> updateInvalidAttempt(String userId, short noOfAttempts, LocalDateTime invalidAttemptDateTime);

    Mono<Long> updateLoginSuccess(String userId, LocalDateTime lastLoginDateTime);

    Mono<Long> updateDisable(String userId, LocalDateTime lockedDateTime, String status);

    Mono<TOtpUserMasterDto> findById(String userId);

    Mono<Long> removeDisabledStatus(String userId, LocalDateTime lockedDateTime, String status);

    Mono<Long> updateEntity(TOtpUserMasterDto tOtpUserMasterDto);

    Mono<Boolean> createEntity(TOtpUserMasterDto tOtpUserMasterDto);
}
