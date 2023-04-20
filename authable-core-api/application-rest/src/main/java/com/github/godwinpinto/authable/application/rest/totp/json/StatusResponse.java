package com.github.godwinpinto.authable.application.rest.totp.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private String statusCode;
    private String statusDescription;
}
