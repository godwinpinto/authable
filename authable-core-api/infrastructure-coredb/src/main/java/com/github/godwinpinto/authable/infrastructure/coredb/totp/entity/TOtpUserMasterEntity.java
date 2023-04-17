package com.github.godwinpinto.authable.infrastructure.coredb.totp.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
//@Builder
@ToString
@Table("TOTP_USER_MASTER")
public class TOtpUserMasterEntity implements Persistable<String> {

    @Id
    @Column("TOTP_USER_ID")
    private String userId;

    @Column("SYSTEM_ID")
    private String systemId;

    @Column("TOTP_USER_SECRET")
    private String userSecret;

    @Column("NO_OF_ATTEMPTS")
    private short noOfAttempts;


    @Column("LAST_LOGIN_DATE_TIME")
    private LocalDateTime lastLoginDateTime;

    @Column("INVALID_ATTEMPT_DATE_TIME")
    private LocalDateTime invalidAttemptDateTime;

    @Column("LOCKED_DATE_TIME")
    private LocalDateTime lockedDateTime;


    @Column("ACCESS_TYPE")
    private String accessType;


    @Column("STATUS")
    private String status;

    @Column("MODIFICATION_ID")
    private String modificationId;

    @Column("MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;

    @Column("CREATION_ID")
    private String creationId;

    @Column("CREATION_DATE_TIME")
    private LocalDateTime creationDateTime;

    @Transient
    @AccessType(AccessType.Type.FIELD)
    private boolean isNew;

    @Override
    public String getId() {
        return userId;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.isNew;
    }

    public TOtpUserMasterEntity setAsNew(boolean isNew) {
        this.isNew = isNew;
        return this;
    }
}
