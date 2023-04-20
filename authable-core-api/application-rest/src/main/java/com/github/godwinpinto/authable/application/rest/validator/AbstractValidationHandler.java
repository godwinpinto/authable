package com.github.godwinpinto.authable.application.rest.validator;

import com.github.godwinpinto.authable.application.rest.auth.json.ApiResponse;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

public abstract class AbstractValidationHandler<T, U extends Validator> {

    private final Class<T> validationClass;

    private final U validator;

    protected AbstractValidationHandler(Class<T> clazz, U validator) {
        this.validationClass = clazz;
        this.validator = validator;
    }

    protected abstract Mono<ServerResponse> processBody(T validBody, final ServerRequest originalRequest);

    public final Mono<ServerResponse> handleRequest(final ServerRequest request) {
        if (this.validationClass == null) {
            return processBody(null, request);
        }
        return request.bodyToMono(this.validationClass)
                .flatMap(body -> {
                    Errors errors = new BeanPropertyBindingResult(body, this.validationClass.getName());
                    this.validator.validate(body, errors);
                    System.out.println("AFTER VALIDATE");

                    if (errors.getAllErrors()
                            .isEmpty()) {
                        return processBody(body, request);
                    } else {
                        System.out.println("ON VALIDATION ERRORS");
                        return onValidationErrors(errors);
                    }
                })
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Parameters in request"))))
                .onErrorResume(e -> {
                    if (e instanceof ResponseStatusException exception) {
                        return ServerResponse.badRequest()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(GenericResponse.builder()
                                        .statusCode("300")
                                        .statusDescription(exception.getReason())
                                        .build()));
                    } else {
                        return ServerResponse.badRequest()
                                .body(BodyInserters
                                        .fromValue(new ApiResponse(400, e.getMessage(), null)));
                    }

                });

    }

    protected Mono<ServerResponse> onValidationErrors(Errors errors) {
        System.out.println("ON VALIDATION ERRORS METHOD HOW");

        if (!errors.getAllErrors()
                .isEmpty()) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getAllErrors()
                    .get(0)
                    .getDefaultMessage()));
        } else {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unknown Error"));
        }
    }
}