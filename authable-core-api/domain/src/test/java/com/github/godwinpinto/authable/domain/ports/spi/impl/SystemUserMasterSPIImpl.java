package com.github.godwinpinto.authable.domain.ports.spi.impl;

import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemUserMasterSPI;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SystemUserMasterSPIImpl implements SystemUserMasterSPI {
  @Override
  public Mono<Long> updateInvalidAttempt(
      String systemId, Short noOfAttempts, LocalDateTime invalidAttemptDateTime) {
    return null;
  }

  @Override
  public Mono<Long> updateLoginSuccess(String systemId, LocalDateTime lastLoginDateTime) {
    return null;
  }

  @Override
  public Mono<Long> updateDisable(String systemId, LocalDateTime lockedDateTime, String status) {
    return null;
  }

  @Override
  public Mono<SystemUserMasterDto> findById(String accessId) {
    return Mono.empty();
  }

  @Override
  public Mono<SystemUserMasterDto> findBySystemUser(String systemId, String userId) {
    return null;
  }
}
