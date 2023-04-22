package com.github.godwinpinto.authable.domain.auth.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SystemUserMasterDto {

  private String accessId;

  private String systemId;

  private String userName;

  private String userSecret;

  private String userFullName;

  private String userIpRange;

  private short noOfAttempts;

  private String status;

  private LocalDateTime lastLoginDateTime;

  private LocalDateTime invalidAttemptDateTime;

  private LocalDateTime lockedDateTime;

  private String modificationId;

  private LocalDateTime modificationDateTime;

  private String creationId;

  private LocalDateTime creationDateTime;
}
