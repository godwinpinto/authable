package com.github.godwinpinto.authable.infrastructure.coredb.totp.repository;

import com.github.godwinpinto.authable.infrastructure.coredb.totp.entity.TOtpUserMasterEntity;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Transactional
@Repository
public interface TOtpUserMasterRepository extends ReactiveCrudRepository<TOtpUserMasterEntity, String> {

    @Query("SELECT * FROM TOTP_USER_MASTER U WHERE U.SYSTEM_ID=:systemId AND U.TOTP_USER_ID=:userId")
    Mono<TOtpUserMasterEntity> findBySystemAndUserId(String systemId, String userId);

    @Modifying
    @Query(value = "update TOTP_USER_MASTER SM SET SM.NO_OF_ATTEMPTS = :noOfAttempts, SM.INVALID_ATTEMPT_DATE_TIME = :invalidAttemptDateTime where SM.TOTP_USER_ID = :userId")
    Mono<Long> updateInvalidAttempt(
            @Param(value = "userId")
            String userId,
            @Param(value = "noOfAttempts")
            short noOfAttempts,
            @Param(value = "invalidAttemptDateTime")
            LocalDateTime invalidAttemptDateTime);

    @Modifying
    @Query("UPDATE TOTP_USER_MASTER SM SET SM.LAST_LOGIN_DATE_TIME = :lastLoginDateTime, SM.NO_OF_ATTEMPTS = 0, SM.INVALID_ATTEMPT_DATE_TIME = NULL WHERE SM.TOTP_USER_ID = :userId")
    Mono<Long> updateLoginSuccess(
            @Param(value = "userId")
            String userId,
            @Param(value = "lastLoginDateTime")
            LocalDateTime lastLoginDateTime);

    @Modifying
    @Query("UPDATE TOTP_USER_MASTER SM SET SM.LOCKED_DATE_TIME = :lockedDateTime, SM.STATUS = :status WHERE SM.TOTP_USER_ID = :userId")
    Mono<Long> updateDisable(
            @Param(value = "userId")
            String userId,
            @Param(value = "lockedDateTime")
            LocalDateTime lockedDateTime,
            @Param(value = "status")
            String status);

    @Modifying
    @Query("UPDATE TOTP_USER_MASTER SM SET SM.MODIFICATION_DATE_TIME = :modificationDateTime, SM.STATUS = :status, SM.TOTP_USER_SECRET='' WHERE SM.TOTP_USER_ID = :userId")
    Mono<Long> removeDisabledStatus(
            @Param(value = "userId")
            String userId,
            @Param(value = "modificationDateTime")
            LocalDateTime modificationDateTime,
            @Param(value = "status")
            String status);


}
