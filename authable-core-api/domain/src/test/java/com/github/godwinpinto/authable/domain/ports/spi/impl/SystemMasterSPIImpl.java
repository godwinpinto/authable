package com.github.godwinpinto.authable.domain.ports.spi.impl;

import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemMasterSPI;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SystemMasterSPIImpl implements SystemMasterSPI {
  @Override
  public Mono<Long> updateDisable(String systemId, LocalDateTime lockedDateTime, String status) {
    return null;
  }

  @Override
  public Mono<SystemMasterDto> findById(String systemId) {
    return null;
  }
}
