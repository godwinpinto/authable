package com.github.godwinpinto.authable.domain.auth.ports.spi;

import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface SystemUserMasterSPI {
    Mono<Long> updateInvalidAttempt(String systemId, short noOfAttempts, LocalDateTime invalidAttemptDateTime);

    Mono<Long> updateLoginSuccess(String systemId, LocalDateTime lastLoginDateTime);

    Mono<Long> updateDisable(String systemId, LocalDateTime lockedDateTime, String status);

    Mono<SystemUserMasterDto> findById(String accessId);

    Mono<SystemUserMasterDto> findBySystemUser(String systemId, String userId);
}
