package com.github.godwinpinto.authable.integration.support;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.repository.TOtpUserMasterRepository;
import com.github.godwinpinto.authable.infrastructure.crypto.adapters.CryptoAlgorithmsAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthCreateDbObjectsIT {

  TOtpUserMasterRepository tOtpUserMasterRepository;
  SystemMasterRepository systemMasterRepository;
  SystemUserMasterRepository systemUserMasterRepository;

  public AuthCreateDbObjectsIT(
      SystemUserMasterRepository systemUserMasterRepository,
      SystemMasterRepository systemMasterRepository) {
    this.systemMasterRepository = systemMasterRepository;
    this.systemUserMasterRepository = systemUserMasterRepository;
  }

  public void loadData() {
    List<SystemMasterEntity> systemMasterEntityList =
        new ArrayList<>(
            List.of(
                createSystem("SYS_A", "A"),
                createSystem("SYS_D", "D"),
                createSystem("SYS_N", "N")));
    this.systemMasterRepository.saveAll(systemMasterEntityList).log().subscribe();

    List<SystemUserMasterEntity> systemUserMasterEntityList =
        new ArrayList<>(
            List.of(
                createSystemUser("SYS_A", "UA", "Test@1234", "A"),
                createSystemUser("SYS_A", "UN", "Test@1234", "N"),
                createSystemUser("SYS_A", "UD", "Test@1234", "D"),
                createSystemUser("SYS_D", "UA", "Test@1234", "A"),
                createSystemUser("SYS_N", "UA", "Test@1234", "A")));
    this.systemUserMasterRepository.saveAll(systemUserMasterEntityList).subscribe();
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
}
