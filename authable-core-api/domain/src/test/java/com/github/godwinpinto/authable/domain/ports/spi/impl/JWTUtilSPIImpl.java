package com.github.godwinpinto.authable.domain.ports.spi.impl;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class JWTUtilSPIImpl implements JWTUtilSPI {
  @Override
  public String getUsernameFromToken(String token) {
    return null;
  }

  @Override
  public Boolean validateToken(String token) {
    return null;
  }

  @Override
  public Map<String, Object> getClaims(String token) {
    return null;
  }

  @Override
  public String generateToken(UserDto userDto) {
    return null;
  }

  @Override
  public Date getExpirationDateFromToken(String token) {
    return null;
  }
}
