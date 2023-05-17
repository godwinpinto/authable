package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationEntryPointFailureHandler;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity()
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

  /**
   * Suppressed as hexagonal architecture and multi-module maven will have such unable to find bean issue with IDE.
   * Since the autowiring is in orchestration module
   */
//  Suppressing warning no longer required
//  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  SecurityConfig(AuthServiceAPI authServiceAPI) {
    this.authServiceAPI = authServiceAPI;
  }

  @Bean
  SecurityWebFilterChain securityWebFilterChain(
      ServerHttpSecurity serverHttpSecurity, AuthenticationManager authManager) {
    return serverHttpSecurity
        .requestCache()
        .requestCache(NoOpServerRequestCache.getInstance()) // disable cache
        .and()
        .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
        .exceptionHandling()
//        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//        .accessDeniedHandler((swe, e) -> Mono.fromRunnable(CustomAccessDeniedHandler::new))
        .and()
        .csrf()
        .disable()
        .formLogin()
        .disable()
        .httpBasic()
        .disable()
        .logout().disable()
        .authorizeExchange()
        .pathMatchers(HttpMethod.OPTIONS)
        .permitAll()
//        .pathMatchers(AUTH_WHITELIST)
//        .permitAll()
//        .pathMatchers(OPEN_LIST)
//        .permitAll()
        .anyExchange()
        .permitAll()
//        .authenticated()
        .and()
        .addFilterAt(bearerAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
        .build();
  }

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return new AuthenticationFailureHandler();
  }

  @Bean
  ReactiveAuthenticationManager reactiveAuthenticationManager() {
    return new AuthenticationManager();
  }

  AuthenticationWebFilter bearerAuthenticationFilter() {
    AuthenticationWebFilter bearerAuthenticationFilter =
        new AuthenticationWebFilter(reactiveAuthenticationManager());
    bearerAuthenticationFilter.setServerAuthenticationConverter(
        new ServerHttpBearerAuthenticationConverter(authServiceAPI));
    ServerAuthenticationEntryPoint bearerEntryPoint = new CustomAuthenticationEntryPoint();
    bearerAuthenticationFilter.setRequiresAuthenticationMatcher(
        ServerWebExchangeMatchers.pathMatchers(SECURED_LIST));
    ServerAuthenticationEntryPointFailureHandler bearerFailureHandler =
        new ServerAuthenticationEntryPointFailureHandler(bearerEntryPoint);
    bearerFailureHandler.setRethrowAuthenticationServiceException(false);
    bearerAuthenticationFilter.setAuthenticationFailureHandler(bearerFailureHandler);
    bearerAuthenticationFilter.setSecurityContextRepository(
        NoOpServerSecurityContextRepository.getInstance());
    return bearerAuthenticationFilter;
  }
}
