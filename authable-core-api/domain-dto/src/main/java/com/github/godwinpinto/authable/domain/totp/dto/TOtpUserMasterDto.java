package com.github.godwinpinto.authable.domain.totp.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

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
