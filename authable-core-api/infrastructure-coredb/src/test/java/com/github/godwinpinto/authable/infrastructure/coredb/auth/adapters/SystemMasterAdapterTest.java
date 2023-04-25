package com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.mappers.SystemMasterMapper;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
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
@ContextConfiguration(classes = {SystemMasterAdapter.class})
@TestPropertySource(properties = {"infrastructure-coredb.system-id-padding=5"})
class SystemMasterAdapterTest {

  @Autowired SystemMasterAdapter systemMasterAdapter;

  @MockBean SystemMasterRepository systemMasterRepository;

  @Test
  void updateDisable_Test() {
    doReturn(Mono.just(1L)).when(systemMasterRepository).updateDisable(any(), any(), any());
    StepVerifier.create(systemMasterAdapter.updateDisable(any(), any(), any()))
        .assertNext(res -> assertEquals(1L, res))
        .verifyComplete();
  }

  @Test
  void findById_Test() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setSystemId("SYSTEM");

    SystemMasterEntity systemMasterEntity = new SystemMasterEntity();
    systemMasterEntity.setSystemId("SYSTEM");

    doReturn(Mono.just(systemMasterEntity)).when(systemMasterRepository).findById("SYSTEM");
    StepVerifier.create(systemMasterAdapter.findById("SYSTEM"))
        .assertNext(res -> assertEquals(res.getSystemId(), systemMasterDto.getSystemId()))
        .verifyComplete();
  }

  @Test
  void systemMasterToDto_Test() {
    assertNull(SystemMasterMapper.INSTANCE.systemMasterToDto(null));
  }
}
