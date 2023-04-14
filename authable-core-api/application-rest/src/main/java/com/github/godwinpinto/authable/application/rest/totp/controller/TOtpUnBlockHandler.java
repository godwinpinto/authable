package com.github.godwinpinto.authable.application.rest.totp.controller;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericResponse;
import com.github.godwinpinto.authable.application.rest.totp.mappers.TOtpRequestResponseDtoMapper;
import com.github.godwinpinto.authable.application.rest.validator.AbstractValidationHandler;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUnBlockUserDto;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class TOtpUnBlockHandler extends AbstractValidationHandler<GenericRequest, Validator> {

    private final TOtpUserServiceAPI tOtpUserServiceAPI;

    private final FetchPrincipalComponent fetchPrincipalComponent;


    TOtpUnBlockHandler(Validator validator, TOtpUserServiceAPI tOtpUserServiceAPI, FetchPrincipalComponent fetchPrincipalComponent) {
        super(GenericRequest.class, validator);
        this.tOtpUserServiceAPI = tOtpUserServiceAPI;
        this.fetchPrincipalComponent = fetchPrincipalComponent;

    }

    @Override
    public Mono<ServerResponse> processBody(GenericRequest genericRequest, ServerRequest serverRequest) {

        return fetchPrincipalComponent.getAuthDetails()
                .flatMap(user -> callService(user, genericRequest))
                .flatMap(this::processSuccessResponse)
                .switchIfEmpty(processEmpty());
    }

    private Mono<TOtpUnBlockUserDto> callService(UserDto user, GenericRequest genericRequest) {
        return tOtpUserServiceAPI
                .unBlockUser(user.getSystemId()
                        .trim(), genericRequest.getUserId()
                        .trim());
    }

    private Mono<ServerResponse> processSuccessResponse(TOtpUnBlockUserDto tOtpUnBlockUserDto) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(
                        TOtpRequestResponseDtoMapper.INSTANCE.unblockResponseFromDto(tOtpUnBlockUserDto)));
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
