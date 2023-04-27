package com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.entity.TOtpUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.mappers.TOtpUserMasterMapper;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.repository.TOtpUserMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {TOtpUserMasterAdapter.class})
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {"infrastructure-coredb.totp-user-id-padding=50"})
class TOtpUserMasterAdapterTest {
  @MockBean TOtpUserMasterRepository tOtpUserMasterRepository;
  @Autowired private TOtpUserMasterAdapter tOtpUserMasterAdapter;

  @Test
  void updateInvalidAttempt_Test() {
    doReturn(Mono.just(1L))
        .when(tOtpUserMasterRepository)
        .updateInvalidAttempt(any(), any(short.class), any());
    StepVerifier.create(
            tOtpUserMasterAdapter.updateInvalidAttempt(
                "ACCESS_ID", (short) 0, DateTimeUtils.getCurrentLocalDateTime()))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void updateLoginSuccess_Test() {
    doReturn(Mono.just(1L)).when(tOtpUserMasterRepository).updateLoginSuccess(any(), any());
    StepVerifier.create(
            tOtpUserMasterAdapter.updateLoginSuccess(
                "ACCESS_ID", DateTimeUtils.getCurrentLocalDateTime()))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void updateDisable_Test() {
    doReturn(Mono.just(1L)).when(tOtpUserMasterRepository).updateDisable(any(), any(), any());
    StepVerifier.create(
            tOtpUserMasterAdapter.updateDisable(
                "ACCESS_ID", DateTimeUtils.getCurrentLocalDateTime(), "N"))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void findById_Test() {
    TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder().userId("TEST_USER").build();

    TOtpUserMasterEntity tOtpUserMasterEntity = new TOtpUserMasterEntity();
    tOtpUserMasterEntity.setUserId("TEST_USER");

    doReturn(Mono.just(tOtpUserMasterEntity))
        .when(tOtpUserMasterRepository)
        .findById(any(String.class));
    StepVerifier.create(tOtpUserMasterAdapter.findById("TEST_USER"))
        .assertNext(res -> assertEquals(res.getUserId(), tOtpUserMasterDto.getUserId()))
        .verifyComplete();
  }

  @Test
  void removeDisabledStatus_Test() {
    doReturn(Mono.just(1L))
        .when(tOtpUserMasterRepository)
        .removeDisabledStatus(any(), any(), any());
    StepVerifier.create(
            tOtpUserMasterAdapter.removeDisabledStatus(
                "ACCESS_ID", DateTimeUtils.getCurrentLocalDateTime(), "N"))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void updateEntity_Test() {
    TOtpUserMasterEntity tOtpUserMasterEntity = new TOtpUserMasterEntity();
    tOtpUserMasterEntity.setUserId("TEST_USER");
    TOtpUserMasterDto userMasterDto = TOtpUserMasterDto.builder().build();
    doReturn(Mono.just(tOtpUserMasterEntity)).when(tOtpUserMasterRepository).save(any());
    StepVerifier.create(tOtpUserMasterAdapter.updateEntity(userMasterDto))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();

    doReturn(Mono.error(new Exception("Some Exception")))
        .when(tOtpUserMasterRepository)
        .save(any());

    StepVerifier.create(tOtpUserMasterAdapter.updateEntity(userMasterDto))
        .assertNext(val -> assertEquals(0L, val))
        .verifyComplete();

    doReturn(Mono.empty()).when(tOtpUserMasterRepository).save(any());

    StepVerifier.create(tOtpUserMasterAdapter.updateEntity(userMasterDto))
        .assertNext(val -> assertEquals(0L, val))
        .verifyComplete();
  }

  @Test
  void createEntity_Test() {
    TOtpUserMasterEntity tOtpUserMasterEntity = new TOtpUserMasterEntity();
    tOtpUserMasterEntity.setUserId("TEST_USER");
    TOtpUserMasterDto userMasterDto = TOtpUserMasterDto.builder().build();
    doReturn(Mono.just(tOtpUserMasterEntity)).when(tOtpUserMasterRepository).save(any());
    StepVerifier.create(tOtpUserMasterAdapter.createEntity(userMasterDto))
        .assertNext(val -> assertEquals(true, val))
        .verifyComplete();

    doReturn(Mono.error(new Exception("Some Exception")))
        .when(tOtpUserMasterRepository)
        .save(any());

    StepVerifier.create(tOtpUserMasterAdapter.createEntity(userMasterDto))
        .assertNext(val -> assertEquals(false, val))
        .verifyComplete();

    doReturn(Mono.empty()).when(tOtpUserMasterRepository).save(any());

    StepVerifier.create(tOtpUserMasterAdapter.createEntity(userMasterDto))
        .assertNext(val -> assertEquals(false, val))
        .verifyComplete();
  }

  @Test
  void entityToDto_Test() {
    assertNull(TOtpUserMasterMapper.INSTANCE.tOtpUserMasterToDto(null));
  }

  @Test
  void dtoToEntity_Test() {
    assertNull(TOtpUserMasterMapper.INSTANCE.dtoToEntity(null));
  }
}
