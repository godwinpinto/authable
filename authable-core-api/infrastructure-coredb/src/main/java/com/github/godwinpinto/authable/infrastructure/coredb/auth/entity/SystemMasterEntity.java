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
@Table("SYSTEM_MASTER")
public class SystemMasterEntity implements Persistable<String> {

  @Id
  @Column("SYSTEM_ID")
  private String systemId;

  @Column("SYSTEM_NAME")
  private String systemName;

  @Column("SYSTEM_DESCRIPTION")
  private String systemDescription;

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
    return systemId;
  }

  @Override
  @Transient
  public boolean isNew() {
    return this.isNew;
  }

  public SystemMasterEntity setAsNew(boolean isNew) {
    this.isNew = isNew;
    return this;
  }
}
