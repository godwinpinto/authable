package com.github.godwinpinto.authable.application.rest.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.SecurityContextServerWebExchange;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

class CustomAuthenticationEntryPointTest {
    /**
     * Method under test: {@link CustomAuthenticationEntryPoint#commence(ServerWebExchange, AuthenticationException)}
     */
    @Test
    void testCommence() {
        CustomAuthenticationEntryPoint customAuthenticationEntryPoint = new CustomAuthenticationEntryPoint();
        ServerWebExchange delegate = mock(ServerWebExchange.class);
        when(delegate.getResponse()).thenReturn(new MockServerHttpResponse());
        SecurityContextServerWebExchange exchange = new SecurityContextServerWebExchange(
                new SecurityContextServerWebExchange(
                        new SecurityContextServerWebExchange(new SecurityContextServerWebExchange(
                                new SecurityContextServerWebExchange(delegate, mock(Mono.class)), mock(Mono.class)), mock(Mono.class)),
                        mock(Mono.class)),
                mock(Mono.class));

        customAuthenticationEntryPoint.commence(exchange, new AccountExpiredException("Msg"));
        verify(delegate).getResponse();
    }
}

