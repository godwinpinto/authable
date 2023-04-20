package com.github.godwinpinto.authable.application.rest.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.SecurityContextServerWebExchange;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

class CustomAccessDeniedHandlerTest {
    /**
     * Method under test: {@link CustomAccessDeniedHandler#handle(ServerWebExchange, AccessDeniedException)}
     */
    @Test
    void testHandle() {
        CustomAccessDeniedHandler customAccessDeniedHandler = new CustomAccessDeniedHandler();
        ServerWebExchange delegate = mock(ServerWebExchange.class);
        when(delegate.getResponse()).thenReturn(new MockServerHttpResponse());
        SecurityContextServerWebExchange exchange = new SecurityContextServerWebExchange(
                new SecurityContextServerWebExchange(
                        new SecurityContextServerWebExchange(new SecurityContextServerWebExchange(
                                new SecurityContextServerWebExchange(delegate, mock(Mono.class)), mock(Mono.class)), mock(Mono.class)),
                        mock(Mono.class)),
                mock(Mono.class));

        customAccessDeniedHandler.handle(exchange, new AccessDeniedException("Msg"));
        verify(delegate).getResponse();
    }
}

