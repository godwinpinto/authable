package com.github.godwinpinto.authable.domain.auth.ports.api;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import java.util.Map;
import reactor.core.publisher.Mono;

public interface AuthServiceAPI {
  Mono<UserDto> findByUsername(String username);

  Mono<UserDto> authenticate(String systemId, String userId, String password);

  String getUsernameFromToken(String token);

  Boolean validateToken(String token);

  Map<String, Object> getClaims(String token);
}
