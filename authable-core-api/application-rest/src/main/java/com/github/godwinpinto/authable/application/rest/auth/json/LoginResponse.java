package com.github.godwinpinto.authable.application.rest.auth.json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private long expiry;
}
