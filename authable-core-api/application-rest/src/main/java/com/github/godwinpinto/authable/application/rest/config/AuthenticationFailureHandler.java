package com.github.godwinpinto.authable.application.rest.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import reactor.core.publisher.Mono;

public class AuthenticationFailureHandler implements ServerAuthenticationFailureHandler {

  @Override
  public Mono<Void> onAuthenticationFailure(
      WebFilterExchange webFilterExchange, AuthenticationException exception) {
    return Mono.error(exception);
  }
}
