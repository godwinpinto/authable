package com.github.godwinpinto.authable.application.rest.totp.controller;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.application.rest.totp.json.VerifyTOtpRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TOtpRoutesConfig {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    @RouterOperations({
            @RouterOperation(path = "/totp/status",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpStatusHandler.class,
                    beanMethod = "getStatus",
                    operation = @Operation(operationId = "getStatus",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = GenericRequest.class))))),
            @RouterOperation(path = "/totp/verify",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpVerifyHandler.class,
                    beanMethod = "verify",
                    operation = @Operation(operationId = "verify",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = VerifyTOtpRequest.class))))),
            @RouterOperation(path = "/totp/subscribe",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpSubscribeHandler.class,
                    beanMethod = "subscribe",
                    operation = @Operation(operationId = "subscribe",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = GenericRequest.class))))),
            @RouterOperation(path = "/totp/unsubscribe",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpUnSubscribeHandler.class,
                    beanMethod = "unsubscribe",
                    operation = @Operation(operationId = "unsubscribe",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = GenericRequest.class))))),
            @RouterOperation(path = "/totp/unblock",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpUnBlockHandler.class,
                    beanMethod = "unblock",
                    operation = @Operation(operationId = "unblock",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = GenericRequest.class))))),
            @RouterOperation(path = "/totp/generate-qr",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = TOtpGenerateQrHandler.class,
                    beanMethod = "generate-qr",
                    operation = @Operation(operationId = "generate-qr",
                            requestBody = @RequestBody(content = @Content(
                                    schema = @Schema(implementation = GenericRequest.class)))))
    })
    RouterFunction<ServerResponse> getStatus(TOtpStatusHandler tOtpStatusHandler,
            @Qualifier("tOtpVerifyHandler")
            TOtpVerifyHandler tOtpVerifyHandler,
            TOtpUnBlockHandler tOtpUnBlockHandler,
            TOtpUnSubscribeHandler tOtpUnSubscribeHandler,
            TOtpGenerateQrHandler tOtpGenerateQrHandler,
            TOtpSubscribeHandler tOtpSubscribeHandler
    ) {
        return route(POST("/totp/status"), tOtpStatusHandler::handleRequest)
                .andRoute(POST("/totp/verify"), tOtpVerifyHandler::handleRequest)
                .andRoute(POST("/totp/subscribe"), tOtpSubscribeHandler::handleRequest)
                .andRoute(POST("/totp/unsubscribe"), tOtpUnSubscribeHandler::handleRequest)
                .andRoute(POST("/totp/unblock"), tOtpUnBlockHandler::handleRequest)
                .andRoute(POST("/totp/generate-qr"), tOtpGenerateQrHandler::handleRequest);
    }

}
