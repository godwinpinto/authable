package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

  private static final String[] AUTH_WHITELIST = {
    "/swagger-resources/**",
    "/configuration/ui",
    "/configuration/security",
    "/swagger-ui.html",
    "/webjars/**",
    "/v3/api-docs/**"
  };
  private static final String[] SECURED_LIST = {"/totp/**"};
  private static final String[] OPEN_LIST = {"/auth/login"};
  private final AuthServiceAPI authServiceAPI;

  SecurityConfig(AuthServiceAPI authServiceAPI) {
    this.authServiceAPI = authServiceAPI;
  }

  @Bean
  SecurityWebFilterChain securityWebFilterChain(
      ServerHttpSecurity http, AuthenticationManager authManager) {

    return http.authorizeExchange()
        .pathMatchers(HttpMethod.OPTIONS)
        .permitAll()
        .pathMatchers(AUTH_WHITELIST)
        .permitAll()
        .pathMatchers(HttpMethod.OPTIONS)
        .permitAll()
        .pathMatchers(OPEN_LIST)
        .permitAll()
        .anyExchange()
        .authenticated()
        .and()
        .csrf()
        .disable()
        .formLogin()
        .disable()
        .httpBasic()
        .disable()
        // NoOpServerSecurityContextRepository makes the session stateless
        .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
        .exceptionHandling()
        .authenticationEntryPoint(
            (swe, e) -> Mono.fromRunnable(CustomAuthenticationEntryPoint::new))
        .accessDeniedHandler((swe, e) -> Mono.fromRunnable(CustomAccessDeniedHandler::new))
        .and()
        .addFilterAt(
            bearerAuthenticationFilter(authManager), SecurityWebFiltersOrder.AUTHENTICATION)
        .build();
  }

  AuthenticationWebFilter bearerAuthenticationFilter(AuthenticationManager authManager) {
    AuthenticationWebFilter bearerAuthenticationFilter = new AuthenticationWebFilter(authManager);
    bearerAuthenticationFilter.setServerAuthenticationConverter(
        new ServerHttpBearerAuthenticationConverter(authServiceAPI));
    bearerAuthenticationFilter.setRequiresAuthenticationMatcher(
        ServerWebExchangeMatchers.pathMatchers(SECURED_LIST));
    return bearerAuthenticationFilter;
  }
}
