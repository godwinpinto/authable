package com.github.godwinpinto.authable.integration.support;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import com.github.godwinpinto.authable.infrastructure.crypto.adapters.CryptoAlgorithmsAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TOtpCreateDbObjectsIT {


  SystemMasterRepository systemMasterRepository;
  SystemUserMasterRepository systemUserMasterRepository;

  TOtpCryptoSPI tOtpCryptoSPI;
  TOtpUserMasterSPI tOtpUserMasterSPI;

  public TOtpCreateDbObjectsIT(
      SystemUserMasterRepository systemUserMasterRepository,
      SystemMasterRepository systemMasterRepository,
      TOtpUserMasterSPI tOtpUserMasterSPI,
      TOtpCryptoSPI tOtpCryptoSPI) {
    this.systemMasterRepository = systemMasterRepository;
    this.systemUserMasterRepository = systemUserMasterRepository;
    this.tOtpCryptoSPI = tOtpCryptoSPI;
    this.tOtpUserMasterSPI = tOtpUserMasterSPI;
  }

  public void loadData() {
    List<SystemMasterEntity> systemMasterEntityList =
        new ArrayList<>(List.of(createSystem("SYS_A", "A")));
    this.systemMasterRepository.saveAll(systemMasterEntityList).log().subscribe();

    List<SystemUserMasterEntity> systemUserMasterEntityList =
        new ArrayList<>(List.of(createSystemUser("SYS_A", "TUA", "Test@1234", "A")));
    this.systemUserMasterRepository.saveAll(systemUserMasterEntityList).subscribe();

    List<TOtpUserMasterDto> tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_VERIFY_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_VERIFY_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_VERIFY_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_VERIFY_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

    tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_UNSUB_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_UNSUB_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_UNSUB_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_UNSUB_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

    tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_UNBLOCK_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_UNBLOCK_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_UNBLOCK_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_UNBLOCK_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

    tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_SUB_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_SUB_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_SUB_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_SUB_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

    tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_GEN_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_GEN_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_GEN_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_GEN_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

    tOtpUserMasterDTOs =
        new ArrayList<>(
            List.of(
                createTOtpUser("SYS_A", "A", "SYS_A_STATUS_UA1"),
                createTOtpUser("SYS_A", "A", "SYS_A_STATUS_UA2"),
                createTOtpUser("SYS_A", "D", "SYS_A_STATUS_UD"),
                createTOtpUser("SYS_A", "N", "SYS_A_STATUS_UN")));
    tOtpUserMasterDTOs.stream()
        .forEach(o -> tOtpUserMasterSPI.createEntity(o).block());

  }

  SystemMasterEntity createSystem(String systemId, String status) {
    SystemMasterEntity systemMaster = new SystemMasterEntity();
    systemMaster.setAsNew(true);
    systemMaster.setCreationId(systemId);
    systemMaster.setSystemId(systemId);
    systemMaster.setSystemDescription(systemId);
    systemMaster.setSystemName(systemId);
    systemMaster.setCreationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    systemMaster.setStatus(status);
    systemMaster.setModificationId(systemId);
    systemMaster.setModificationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    return systemMaster;
  }

  SystemUserMasterEntity createSystemUser(
      String systemId, String userId, String secret, String status) {
    SystemUserMasterEntity entity = new SystemUserMasterEntity();
    entity.setCreationId(userId);
    entity.setSystemId(systemId);
    entity.setCreationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    entity.setStatus(status);
    entity.setAsNew(true);
    entity.setModificationId(userId);
    entity.setAccessId(UUID.randomUUID().toString());
    entity.setUserName(userId);
    entity.setModificationDateTime(DateTimeUtils.getCurrentLocalDateTime());
    entity.setNoOfAttempts((short) 0);
    entity.setUserFullName(userId);
    entity.setUserIpRange("");
    CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();
    entity.setUserSecret(cryptoAlgorithmsAdapter.generateHashFromSecret(systemId, userId, secret));
    return entity;
  }

  TOtpUserMasterDto createTOtpUser(String systemId, String status, String userSystemId) {
    String secret = tOtpCryptoSPI.generateSecretKey(userSystemId);
    TOtpUserMasterDto user1 =
        TOtpUserMasterDto.builder()
            .userSecret(secret)
            .userId(userSystemId)
            .accessType("B")
            .systemId(systemId)
            .status(status)
            .creationId("TEST_USER")
            .modificationId("TEST_USER")
            .noOfAttempts((short) 0)
            .build();
    return user1;
  }
}
