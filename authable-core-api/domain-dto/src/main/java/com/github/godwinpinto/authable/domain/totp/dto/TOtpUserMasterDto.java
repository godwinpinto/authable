package com.github.godwinpinto.authable.domain.totp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TOtpUserMasterDto {

    private String userId;

    private String systemId;

    private String userSecret;

    private short noOfAttempts;

    private LocalDateTime lastLoginDateTime;

    private LocalDateTime invalidAttemptDateTime;

    private LocalDateTime lockedDateTime;

    private String accessType;

    private String status;

    private String modificationId;

    private LocalDateTime modificationDateTime;

    private String creationId;

    private LocalDateTime creationDateTime;

}
