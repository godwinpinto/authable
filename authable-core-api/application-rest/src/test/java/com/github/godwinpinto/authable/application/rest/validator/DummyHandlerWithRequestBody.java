package com.github.godwinpinto.authable.application.rest.validator;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.github.godwinpinto.authable.application.rest.auth.json.ApiResponse;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericResponse;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class DummyHandlerWithRequestBody
    extends AbstractValidationHandler<GenericRequest, Validator> {

  private final AuthServiceAPI authServiceAPI;

  DummyHandlerWithRequestBody(Validator validator, AuthServiceAPI authServiceAPI) {
    super(GenericRequest.class, validator);
    this.authServiceAPI = authServiceAPI;
  }

  public RouterFunction<ServerResponse> doSomething() {
    return route(POST("/test-with-request-body"), this::handleRequest);
  }

  @Override
  public Mono<ServerResponse> processBody(
      GenericRequest genericRequest, ServerRequest serverRequest) {

    return authServiceAPI
        .authenticate("", "", "")
        .flatMap(this::prepareSuccessResponse)
        .switchIfEmpty(prepareOnEmptyResponse());
  }

  private Mono<ServerResponse> prepareSuccessResponse(UserDto userDto) {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            BodyInserters.fromValue(
                GenericResponse.builder().statusCode("200").statusDescription("Success").build()));
  }

  private Mono<ServerResponse> prepareOnEmptyResponse() {
    return ServerResponse.badRequest()
        .body(BodyInserters.fromValue(new ApiResponse(400, "Empty Response", null)));
  }
}
