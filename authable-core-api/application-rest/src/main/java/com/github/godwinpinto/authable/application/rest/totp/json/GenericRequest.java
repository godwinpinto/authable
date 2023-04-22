package com.github.godwinpinto.authable.application.rest.totp.json;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericRequest {

  @NotBlank(message = "User Id cannot be empty")
  private String userId;
}
