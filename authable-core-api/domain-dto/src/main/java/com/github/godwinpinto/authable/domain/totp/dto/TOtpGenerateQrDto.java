package com.github.godwinpinto.authable.domain.totp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TOtpGenerateQrDto {

  private String statusCode;
  private String statusDescription;
  private String qrImage;
}
