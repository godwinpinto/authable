package com.github.godwinpinto.authable.infrastructure.coredb.auth.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@Table("SYSTEM_USER_MASTER")
public class SystemUserMasterEntity {

    @Id
    @Column("ACCESS_ID")
    private String accessId;

    @Column("SYSTEM_ID")
    private String systemId;

    @Column("USER_NAME")
    private String userName;

    @Column("USER_SECRET")
    private String userSecret;

    @Column("USER_FULL_NAME")
    private String userFullName;


    @Column("USER_IP_RANGE")
    private String userIpRange;

    @Column("NO_OF_ATTEMPTS")
    private short noOfAttempts;

    @Column("STATUS")
    private String status;

    @Column("LAST_LOGIN_DATE_TIME")
    private LocalDateTime lastLoginDateTime;

    @Column("INVALID_ATTEMPT_DATE_TIME")
    private LocalDateTime invalidAttemptDateTime;

    @Column("LOCKED_DATE_TIME")
    private LocalDateTime lockedDateTime;

    @Column("MODIFICATION_ID")
    private String modificationId;

    @Column("MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;

    @Column("CREATION_ID")
    private String creationId;

    @Column("CREATION_DATE_TIME")
    private LocalDateTime creationDateTime;

}
