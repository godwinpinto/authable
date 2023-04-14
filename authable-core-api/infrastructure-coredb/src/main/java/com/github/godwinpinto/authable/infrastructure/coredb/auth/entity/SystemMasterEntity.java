package com.github.godwinpinto.authable.infrastructure.coredb.auth.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("SYSTEM_MASTER")
public class SystemMasterEntity {

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

}
