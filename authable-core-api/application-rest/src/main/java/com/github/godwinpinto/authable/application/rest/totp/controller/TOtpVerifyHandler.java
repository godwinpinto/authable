package com.github.godwinpinto.authable.application.rest.totp.controller;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericResponse;
import com.github.godwinpinto.authable.application.rest.totp.json.VerifyTOtpRequest;
import com.github.godwinpinto.authable.application.rest.totp.mappers.TOtpRequestResponseDtoMapper;
import com.github.godwinpinto.authable.application.rest.validator.AbstractValidationHandler;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpVerifyDto;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component("tOtpVerifyHandler")
public class TOtpVerifyHandler extends AbstractValidationHandler<VerifyTOtpRequest, Validator> {

    private final TOtpUserServiceAPI tOtpUserServiceAPI;
    private final FetchPrincipalComponent fetchPrincipalComponent;


    TOtpVerifyHandler(Validator validator, TOtpUserServiceAPI tOtpUserServiceAPI, FetchPrincipalComponent fetchPrincipalComponent) {
        super(VerifyTOtpRequest.class, validator);
        this.tOtpUserServiceAPI = tOtpUserServiceAPI;
        this.fetchPrincipalComponent = fetchPrincipalComponent;

    }

    @Override
    public Mono<ServerResponse> processBody(VerifyTOtpRequest verifyTOtpRequest, ServerRequest serverRequest) {
        return fetchPrincipalComponent.getAuthDetails()
                .flatMap(user -> callService(user, verifyTOtpRequest))
                .flatMap(this::processSuccessResponse)
                .switchIfEmpty(processEmpty());
    }

    private Mono<TOtpVerifyDto> callService(UserDto user, VerifyTOtpRequest verifyTOtpRequest) {
        return tOtpUserServiceAPI
                .verify(user.getSystemId()
                        .trim(), verifyTOtpRequest.getUserId()
                        .trim(), verifyTOtpRequest.getOtp());
    }

    private Mono<ServerResponse> processSuccessResponse(TOtpVerifyDto tOtpVerifyDto) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(
                        TOtpRequestResponseDtoMapper.INSTANCE.verifyResponseFromDto(tOtpVerifyDto)));
    }

    private Mono<ServerResponse> processEmpty() {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(GenericResponse.builder()
                        .statusCode("300")
                        .statusDescription("No active subscription")
                        .build()));
    }

}
