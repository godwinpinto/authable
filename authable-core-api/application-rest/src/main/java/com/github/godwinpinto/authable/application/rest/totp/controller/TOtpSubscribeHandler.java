package com.github.godwinpinto.authable.application.rest.totp.controller;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.application.rest.totp.mappers.TOtpRequestResponseDtoMapper;
import com.github.godwinpinto.authable.application.rest.validator.AbstractValidationHandler;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpCreateNewDto;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TOtpSubscribeHandler extends AbstractValidationHandler<GenericRequest, Validator> {

  private final TOtpUserServiceAPI tOtpUserServiceAPI;

  private final FetchPrincipalComponent fetchPrincipalComponent;

  TOtpSubscribeHandler(
      Validator validator,
      TOtpUserServiceAPI tOtpUserServiceAPI,
      FetchPrincipalComponent fetchPrincipalComponent) {
    super(GenericRequest.class, validator);
    this.tOtpUserServiceAPI = tOtpUserServiceAPI;
    this.fetchPrincipalComponent = fetchPrincipalComponent;
  }

  @Override
  public Mono<ServerResponse> processBody(
      GenericRequest genericRequest, ServerRequest serverRequest) {
    return fetchPrincipalComponent
        .getAuthDetails()
        .flatMap(user -> callService(user, genericRequest))
        .flatMap(this::processSuccessResponse)
        .switchIfEmpty(processEmpty());
  }

  private Mono<TOtpCreateNewDto> callService(UserDto user, GenericRequest genericRequest) {
    return tOtpUserServiceAPI.createTOtpSecret(
        user.getSystemId().trim(), genericRequest.getUserId().trim());
  }

  private Mono<ServerResponse> processSuccessResponse(TOtpCreateNewDto tOtpCreateNewDto) {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            BodyInserters.fromValue(
                TOtpRequestResponseDtoMapper.INSTANCE.createNewResponseFromDto(tOtpCreateNewDto)));
  }

  private Mono<ServerResponse> processEmpty() {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            BodyInserters.fromValue(
                TOtpCreateNewDto.builder()
                    .statusCode("300")
                    .statusDescription("No active subscription")
                    .build()));
  }
}
