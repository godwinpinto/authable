package com.github.godwinpinto.authable.application.rest.auth.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.github.godwinpinto.authable.application.rest.auth.json.LoginRequest;
import com.github.godwinpinto.authable.application.rest.auth.json.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SystemRoutesConfig {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Bean
  @RouterOperation(
      path = "/auth/login",
      produces = {MediaType.APPLICATION_JSON_VALUE},
      method = RequestMethod.POST,
      beanClass = SystemHandler.class,
      beanMethod = "login",
      operation =
          @Operation(
              operationId = "login",
              responses = {
                @ApiResponse(
                    responseCode = "200",
                    description = "A fresh token would be issued",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class))),
                @ApiResponse(responseCode = "401", description = "Invalid credentials"),
                @ApiResponse(responseCode = "400", description = "Parameters cannot be blank")
              },
              requestBody =
                  @RequestBody(
                      content = @Content(schema = @Schema(implementation = LoginRequest.class)))))
  RouterFunction<ServerResponse> reissueToken(SystemHandler systemHandler) {
    return route(POST("/auth/login"), systemHandler::handleRequest);
  }
}
