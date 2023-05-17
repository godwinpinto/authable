package com.github.godwinpinto.authable.application.rest.exception;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class DummyRoutesConfig {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Bean
  RouterFunction<ServerResponse> dummyURI(DummyUnauthorizedHandler dummyUnauthorizedHandler,
      DummyResponseStatusHandler dummyResponseStatusHandler) {
    return route(POST("/dummy-unauthorized"), dummyUnauthorizedHandler::handleRequest)
        .andRoute(POST("/dummy-response-status"), dummyResponseStatusHandler::handleRequest);
  }
}
