package com.github.godwinpinto.authable.infrastructure.coredb.auth.repository;

import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import java.time.LocalDateTime;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Transactional
@Repository
public interface SystemUserMasterRepository
    extends ReactiveCrudRepository<SystemUserMasterEntity, String> {

  @Modifying
  @Query(
      value =
          "update SYSTEM_USER_MASTER SM set SM.NO_OF_ATTEMPTS = :noOfAttempts, SM.INVALID_ATTEMPT_DATE_TIME = :invalidAttemptDateTime where SM.ACCESS_ID = :accessId ")
  Mono<Long> updateInvalidAttempt(
      @Param(value = "accessId") String accessId,
      @Param(value = "noOfAttempts") short noOfAttempts,
      @Param(value = "invalidAttemptDateTime") LocalDateTime invalidAttemptDateTime);

  @Modifying
  @Query(
      "UPDATE SYSTEM_USER_MASTER SM SET SM.LAST_LOGIN_DATE_TIME = :lastLoginDateTime, SM.NO_OF_ATTEMPTS = 0, SM.INVALID_ATTEMPT_DATE_TIME = NULL WHERE SM.ACCESS_ID = :accessId")
  Mono<Long> updateLoginSuccess(
      @Param(value = "accessId") String accessId,
      @Param(value = "lastLoginDateTime") LocalDateTime lastLoginDateTime);

  @Modifying
  @Query(
      "UPDATE SYSTEM_USER_MASTER SM SET SM.LOCKED_DATE_TIME = :lockedDateTime, SM.STATUS = :status WHERE SM.ACCESS_ID = :accessId")
  Mono<Long> updateDisable(
      @Param(value = "accessId") String accessId,
      @Param(value = "lockedDateTime") LocalDateTime lockedDateTime,
      @Param(value = "status") String status);

  @Query("SELECT * FROM SYSTEM_USER_MASTER U WHERE U.SYSTEM_ID=:systemId AND U.USER_NAME=:userId")
  Mono<SystemUserMasterEntity> findBySystemUser(String systemId, String userId);
}
