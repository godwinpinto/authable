package com.github.godwinpinto.authable.domain.auth.ports.spi;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;

import java.util.Date;
import java.util.Map;

public interface JWTUtilSPI {
    String getUsernameFromToken(String token);

    Boolean validateToken(String token);

    Map<String, Object> getClaims(String token);

    String generateToken(UserDto userDto);

    Date getExpirationDateFromToken(String token);

}
