package com.github.godwinpinto.authable.infrastructure.coredb.auth.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("SYSTEM_USER_MASTER")
public class SystemUserMasterEntity implements Persistable<String> {

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

  @Transient
  @AccessType(AccessType.Type.FIELD)
  private boolean isNew;

  @Override
  public String getId() {
    return accessId;
  }

  @Override
  @Transient
  public boolean isNew() {
    return this.isNew;
  }

  public SystemUserMasterEntity setAsNew(boolean isNew) {
    this.isNew = isNew;
    return this;
  }
}
