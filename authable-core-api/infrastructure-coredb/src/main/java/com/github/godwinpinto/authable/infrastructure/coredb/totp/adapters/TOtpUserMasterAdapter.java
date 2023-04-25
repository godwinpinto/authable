package com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.entity.TOtpUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.mappers.TOtpUserMasterMapper;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.repository.TOtpUserMasterRepository;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

public class TOtpUserMasterAdapter implements TOtpUserMasterSPI {

  private final TOtpUserMasterRepository tOtpUserMasterRepository;

  @Value("${infrastructure-coredb.totp-user-id-padding}")
  private int tOtpUserIdPadding;

  public TOtpUserMasterAdapter(TOtpUserMasterRepository tOtpUserMasterRepository) {
    this.tOtpUserMasterRepository = tOtpUserMasterRepository;
  }

  @Override
  public Mono<Long> updateDisable(String userId, LocalDateTime lockedDateTime, String status) {
    return tOtpUserMasterRepository.updateDisable(
        StringUtils.rightPad(userId, tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR),
        lockedDateTime,
        status);
  }

  @Override
  public Mono<TOtpUserMasterDto> findById(String userId) {
    return tOtpUserMasterRepository
        .findById(StringUtils.rightPad(userId, tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR))
        .flatMap(entity -> Mono.just(TOtpUserMasterMapper.INSTANCE.tOtpUserMasterToDto(entity)));
  }

  @Override
  public Mono<Long> updateInvalidAttempt(
      String systemId, short noOfAttempts, LocalDateTime invalidAttemptDateTime) {
    return tOtpUserMasterRepository.updateInvalidAttempt(
        StringUtils.rightPad(systemId, tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR),
        noOfAttempts,
        invalidAttemptDateTime);
  }

  @Override
  public Mono<Long> updateLoginSuccess(String userId, LocalDateTime lastLoginDateTime) {
    return tOtpUserMasterRepository.updateLoginSuccess(
        StringUtils.rightPad(userId, tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR),
        lastLoginDateTime);
  }

  @Override
  public Mono<Long> removeDisabledStatus(
      String userId, LocalDateTime lockedDateTime, String status) {
    return tOtpUserMasterRepository.removeDisabledStatus(
        StringUtils.rightPad(userId, tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR),
        lockedDateTime,
        status);
  }

  public Mono<Long> updateEntity(TOtpUserMasterDto tOtpUserMasterDto) {

    TOtpUserMasterEntity tOtpUserMasterEntity =
        TOtpUserMasterMapper.INSTANCE.dtoToEntity(tOtpUserMasterDto);
    tOtpUserMasterEntity.setUserId(
        StringUtils.rightPad(
            tOtpUserMasterEntity.getUserId(), tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR));
    tOtpUserMasterEntity.setAsNew(false);
    return tOtpUserMasterRepository
        .save(tOtpUserMasterEntity)
        .flatMap(tOtpUserMasterEntity1 -> Mono.just(1L))
        .switchIfEmpty(Mono.just(0L))
        .onErrorResume(e -> Mono.just(0L));
  }

  public Mono<Boolean> createEntity(TOtpUserMasterDto tOtpUserMasterDto) {
    TOtpUserMasterEntity tOtpUserMasterEntity =
        TOtpUserMasterMapper.INSTANCE.dtoToEntity(tOtpUserMasterDto);
    tOtpUserMasterEntity.setAsNew(true);
    tOtpUserMasterEntity.setUserId(
        StringUtils.rightPad(
            tOtpUserMasterEntity.getUserId(), tOtpUserIdPadding, ApplicationConstants.DB_PAD_CHAR));
    tOtpUserMasterEntity.setCreationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    tOtpUserMasterEntity.setModificationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    return tOtpUserMasterRepository
        .save(tOtpUserMasterEntity)
        .flatMap(tOtpUserMasterEntity1 -> Mono.just(true))
        .switchIfEmpty(Mono.just(false))
        .onErrorResume(e -> Mono.just(false));
  }
}
