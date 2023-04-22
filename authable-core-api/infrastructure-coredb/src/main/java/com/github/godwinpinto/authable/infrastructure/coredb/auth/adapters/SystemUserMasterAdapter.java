package com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.mappers.SystemUserMasterMapper;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

public class SystemUserMasterAdapter implements SystemUserMasterSPI {

  private final SystemUserMasterRepository systemUserMasterRepository;

  @Value("${infrastructure-coredb.system-id-padding}")
  private int systemUserSpacePadding;

  public SystemUserMasterAdapter(SystemUserMasterRepository systemUserMasterRepository) {
    this.systemUserMasterRepository = systemUserMasterRepository;
  }

  @Override
  public Mono<Long> updateInvalidAttempt(
      String accessId, Short noOfAttempts, LocalDateTime invalidAttemptDateTime) {
    return systemUserMasterRepository.updateInvalidAttempt(
        StringUtils.rightPad(accessId, systemUserSpacePadding, ApplicationConstants.DB_PAD_CHAR),
        noOfAttempts,
        invalidAttemptDateTime);
  }

  @Override
  public Mono<Long> updateLoginSuccess(String accessId, LocalDateTime lastLoginDateTime) {
    return systemUserMasterRepository.updateLoginSuccess(
        StringUtils.rightPad(accessId, systemUserSpacePadding, ApplicationConstants.DB_PAD_CHAR),
        lastLoginDateTime);
  }

  @Override
  public Mono<Long> updateDisable(String accessId, LocalDateTime lockedDateTime, String status) {
    return systemUserMasterRepository.updateDisable(
        StringUtils.rightPad(accessId, systemUserSpacePadding, ApplicationConstants.DB_PAD_CHAR),
        lockedDateTime,
        status);
  }

  @Override
  public Mono<SystemUserMasterDto> findById(String accessId) {
    return systemUserMasterRepository
        .findById(
            StringUtils.rightPad(
                accessId, systemUserSpacePadding, ApplicationConstants.DB_PAD_CHAR))
        .flatMap(
            entity -> Mono.just(SystemUserMasterMapper.INSTANCE.systemUserMasterToDto(entity)));
  }

  @Override
  public Mono<SystemUserMasterDto> findBySystemUser(String systemId, String userId) {
    return systemUserMasterRepository
        .findBySystemUser(
            StringUtils.rightPad(
                systemId, systemUserSpacePadding, ApplicationConstants.DB_PAD_CHAR),
            userId)
        .flatMap(
            entity -> Mono.just(SystemUserMasterMapper.INSTANCE.systemUserMasterToDto(entity)));
  }
}
