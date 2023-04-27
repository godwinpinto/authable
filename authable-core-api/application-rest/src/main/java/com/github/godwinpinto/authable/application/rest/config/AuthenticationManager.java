package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

@Configuration
public class AuthenticationManager implements ReactiveAuthenticationManager {

  /**
   * private AuthServiceAPI authServiceAPI;
   *
   * <p>public AuthenticationManager(AuthServiceAPI authServiceAPI) { this.authServiceAPI =
   * authServiceAPI; }
   */
  @Override
  public Mono<Authentication> authenticate(Authentication authentication) {
    UserDto principal = (UserDto) authentication.getPrincipal();

    return Mono.just(
        new UsernamePasswordAuthenticationToken(
            principal, authentication.getCredentials(), principal.getAuthorities()));
  }
}
