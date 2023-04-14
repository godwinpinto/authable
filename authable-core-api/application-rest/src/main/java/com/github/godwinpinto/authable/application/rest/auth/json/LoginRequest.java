package com.github.godwinpinto.authable.application.rest.auth.json;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "System Id cannot be blank")
    private String systemId;

    @NotBlank(message = "User Id cannot be blank")
    private String userId;

    @NotBlank(message = "User Secret cannot be blank")
    private String userSecret;
}
