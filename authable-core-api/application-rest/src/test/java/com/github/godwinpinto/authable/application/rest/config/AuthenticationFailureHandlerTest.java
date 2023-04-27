package com.github.godwinpinto.authable.application.rest.config;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import reactor.test.StepVerifier;

class AuthenticationFailureHandlerTest {

  @Test
  void onAuthenticationFailure_Test() {

    WebFilterExchange webFilterExchange = mock(WebFilterExchange.class);

    AuthenticationFailureHandler authenticationFailureHandler = new AuthenticationFailureHandler();

    AuthenticationException exception = new AuthenticationServiceException("Some Exception");

    StepVerifier.create(
            authenticationFailureHandler.onAuthenticationFailure(webFilterExchange, exception))
        .expectErrorMatches(
            e ->
                e instanceof AuthenticationException
                    && e.getMessage().equals(exception.getMessage()))
        .verify();
  }
}
