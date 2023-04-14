package com.github.godwinpinto.authable.domain.auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemMasterDto {

    private String systemId;

    private String systemName;

    private String systemDescription;

    private String status;

    private String modificationId;

    private LocalDateTime modificationDateTime;

    private String creationId;

    private LocalDateTime creationDateTime;
}
