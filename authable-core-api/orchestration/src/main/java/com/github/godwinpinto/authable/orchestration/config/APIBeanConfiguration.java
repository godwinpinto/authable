package com.github.godwinpinto.authable.orchestration.config;

import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import com.github.godwinpinto.authable.domain.auth.usecase.UserService;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIBeanConfiguration {

  private UserService userService;

  private TOtpUserUseCase tOtpUserUseCase;

  public APIBeanConfiguration(UserService userService, TOtpUserUseCase tOtpUserUseCase) {
    this.userService = userService;
    this.tOtpUserUseCase = tOtpUserUseCase;
  }

  @Bean
  AuthServiceAPI authServiceAPI() {
    return userService;
  }

  @Bean
  TOtpUserServiceAPI tOtpUserServiceAPI() {
    return tOtpUserUseCase;
  }
}
