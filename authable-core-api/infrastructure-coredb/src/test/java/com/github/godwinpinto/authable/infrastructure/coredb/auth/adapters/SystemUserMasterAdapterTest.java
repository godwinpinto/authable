package com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.mappers.SystemUserMasterMapper;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SystemUserMasterAdapter.class})
@TestPropertySource(properties = {"infrastructure-coredb.system-id-padding=5"})
class SystemUserMasterAdapterTest {
  @Autowired SystemUserMasterAdapter systemUserMasterAdapter;

  @MockBean SystemUserMasterRepository systemUserMasterRepository;

  @Test
  void updateInvalidAttempt_Test() {
    doReturn(Mono.just(1L))
        .when(systemUserMasterRepository)
        .updateInvalidAttempt(any(), any(short.class), any());
    StepVerifier.create(
            systemUserMasterAdapter.updateInvalidAttempt(
                "ACCESS_ID", (short) 0, DateTimeUtils.getCurrentLocalDateTime()))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void updateLoginSuccess_Test() {
    doReturn(Mono.just(1L)).when(systemUserMasterRepository).updateLoginSuccess(any(), any());
    StepVerifier.create(
            systemUserMasterAdapter.updateLoginSuccess(
                "ACCESS_ID", DateTimeUtils.getCurrentLocalDateTime()))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void updateDisable_Test() {
    doReturn(Mono.just(1L)).when(systemUserMasterRepository).updateDisable(any(), any(), any());
    StepVerifier.create(
            systemUserMasterAdapter.updateDisable(
                "ACCESS_ID", DateTimeUtils.getCurrentLocalDateTime(), "N"))
        .assertNext(val -> assertEquals(1L, val))
        .verifyComplete();
  }

  @Test
  void findById_Test() {
    SystemUserMasterDto userMasterDto = new SystemUserMasterDto();
    userMasterDto.setUserName("TEST_USER");

    SystemUserMasterEntity systemUserMasterEntity =new
        SystemUserMasterEntity();
   systemUserMasterEntity.setUserName("TEST_USER");

    doReturn(Mono.just(systemUserMasterEntity))
        .when(systemUserMasterRepository)
        .findById("TEST_USER");
    StepVerifier.create(systemUserMasterAdapter.findById("TEST_USER"))
        .assertNext(res -> assertEquals(res.getUserName(), userMasterDto.getUserName()))
        .verifyComplete();
  }

  @Test
  void findBySystemUser_Test() {
    SystemUserMasterDto userMasterDto = new SystemUserMasterDto();
    userMasterDto.setUserName("TEST_USER");

    SystemUserMasterEntity systemUserMasterEntity =new
        SystemUserMasterEntity();
    systemUserMasterEntity.setUserName("TEST_USER");

    doReturn(Mono.just(systemUserMasterEntity))
        .when(systemUserMasterRepository)
        .findBySystemUser("TEST_SYSTEM", "TEST_USER_NAME");
    StepVerifier.create(systemUserMasterAdapter.findBySystemUser("TEST_SYSTEM", "TEST_USER_NAME"))
        .assertNext(res -> assertEquals(res.getUserName(), userMasterDto.getUserName()))
        .verifyComplete();
  }

  @Test
  void entityToDto() {
    assertNull(SystemUserMasterMapper.INSTANCE.systemUserMasterToDto(null));
  }
}
