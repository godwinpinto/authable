package com.github.godwinpinto.authable.domain.auth.ports.spi;

import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import java.time.LocalDateTime;
import reactor.core.publisher.Mono;

public interface SystemUserMasterSPI {
  Mono<Long> updateInvalidAttempt(
      String systemId, Short noOfAttempts, LocalDateTime invalidAttemptDateTime);

  Mono<Long> updateLoginSuccess(String systemId, LocalDateTime lastLoginDateTime);

  Mono<Long> updateDisable(String systemId, LocalDateTime lockedDateTime, String status);

  Mono<SystemUserMasterDto> findById(String accessId);

  Mono<SystemUserMasterDto> findBySystemUser(String systemId, String userId);
}
