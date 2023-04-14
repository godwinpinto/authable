package com.github.godwinpinto.authable.application.rest.totp.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.support.ServerRequestWrapper;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpGenerateQrHandler.class})
@ExtendWith(SpringExtension.class)
class TOtpGenerateQrHandlerTest {
    @MockBean
    private FetchPrincipalComponent fetchPrincipalComponent;

    @Autowired
    private TOtpGenerateQrHandler tOtpGenerateQrHandler;

    @MockBean
    private TOtpUserServiceAPI tOtpUserServiceAPI;

    @MockBean
    private Validator validator;

    /**
     * Method under test: {@link TOtpGenerateQrHandler#processBody(GenericRequest, ServerRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessBody() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Delegate must not be null
        //   See https://diff.blue/R013 to resolve this issue.

        GenericRequest genericRequest = new GenericRequest("42");
        tOtpGenerateQrHandler.processBody(genericRequest,
                new ServerRequestWrapper(new ServerRequestWrapper(new ServerRequestWrapper(new ServerRequestWrapper(null)))));
    }

    /**
     * Method under test: {@link TOtpGenerateQrHandler#processBody(GenericRequest, ServerRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessBody2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent.getAuthDetails()" is null
        //       at com.github.godwinpinto.authable.application.rest.totp.controller.TOtpGenerateQrHandler.processBody(TOtpGenerateQrHandler.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        when(fetchPrincipalComponent.getAuthDetails()).thenReturn(null);
        GenericRequest genericRequest = mock(GenericRequest.class);
        tOtpGenerateQrHandler.processBody(genericRequest, new ServerRequestWrapper(new ServerRequestWrapper(
                new ServerRequestWrapper(new ServerRequestWrapper(mock(ServerRequestWrapper.class))))));
    }

    /**
     * Method under test: {@link TOtpGenerateQrHandler#processBody(GenericRequest, ServerRequest)}
     */
    @Test
    void testProcessBody3() {
        Mono<UserDto> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<UserDto, Mono<Object>>>any())).thenReturn(null);
        when(fetchPrincipalComponent.getAuthDetails()).thenReturn(mono);
        GenericRequest genericRequest = mock(GenericRequest.class);
        assertNull(tOtpGenerateQrHandler.processBody(genericRequest, new ServerRequestWrapper(new ServerRequestWrapper(
                new ServerRequestWrapper(new ServerRequestWrapper(mock(ServerRequestWrapper.class)))))));
        verify(fetchPrincipalComponent).getAuthDetails();
        verify(mono).flatMap(Mockito.<Function<UserDto, Mono<Object>>>any());
    }
}

