package com.github.godwinpinto.authable.domain.auth.ports.spi;

import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import java.time.LocalDateTime;
import reactor.core.publisher.Mono;

public interface SystemMasterSPI {

  Mono<Long> updateDisable(String systemId, LocalDateTime lockedDateTime, String status);

  Mono<SystemMasterDto> findById(String systemId);
}
