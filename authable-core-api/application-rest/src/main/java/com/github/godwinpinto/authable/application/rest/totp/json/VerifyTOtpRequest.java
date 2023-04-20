package com.github.godwinpinto.authable.application.rest.totp.json;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VerifyTOtpRequest {

    @NotBlank(message = "User Id cannot be empty")
    private String userId;

    @NotBlank(message = "OTP cannot be empty")
    private String otp;
}
