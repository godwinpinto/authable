package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.MatcherSecurityWebFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.WebFilter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {SecurityConfig.class,
        AuthenticationManager.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigTest {
    @MockBean
    private AuthServiceAPI authServiceAPI;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityConfig securityConfig;

    /**
     * Method under test: {@link SecurityConfig#securityWebFilterChain(ServerHttpSecurity, AuthenticationManager)}
     */
    @Test
    void testSecurityWebFilterChain() {
        ServerHttpSecurity http = ServerHttpSecurity.http();
        assertTrue(
                securityConfig.securityWebFilterChain(http, authenticationManager) instanceof MatcherSecurityWebFilterChain);
    }

    /**
     * Method under test: {@link SecurityConfig#securityWebFilterChain(ServerHttpSecurity, AuthenticationManager)}
     */
    @Test
    void testSecurityWebFilterChain2() {
        ServerHttpSecurity http = ServerHttpSecurity.http();
        http.addFilterAt(mock(WebFilter.class), SecurityWebFiltersOrder.FIRST);
        assertTrue(
                securityConfig.securityWebFilterChain(http, authenticationManager) instanceof MatcherSecurityWebFilterChain);
    }

    /**
     * Method under test: {@link SecurityConfig#bearerAuthenticationFilter(AuthenticationManager)}
     */
    @Test
    void testBearerAuthenticationFilter() {
        assertDoesNotThrow(() -> securityConfig.bearerAuthenticationFilter(authenticationManager));
    }
}

