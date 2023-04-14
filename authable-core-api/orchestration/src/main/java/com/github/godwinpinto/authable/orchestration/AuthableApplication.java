package com.github.godwinpinto.authable.orchestration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(basePackages = {"com.github.godwinpinto.authable.infrastructure.coredb"},
        basePackageClasses = {})
@OpenAPIDefinition(info = @Info(title = "Authable API", version = "1.0", description = "Documentation APIs v1.0"))
@SpringBootApplication(scanBasePackages = "com.github.godwinpinto.authable")
public class AuthableApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthableApplication.class, args);
  }

}
