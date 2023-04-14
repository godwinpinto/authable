package com.github.godwinpinto.authable.application.rest.auth.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.application.rest.auth.json.LoginRequest;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
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

@ContextConfiguration(classes = {SystemHandler.class})
@ExtendWith(SpringExtension.class)
class SystemHandlerTest {
    @MockBean
    private AuthServiceAPI authServiceAPI;

    @Autowired
    private SystemHandler systemHandler;

    @MockBean
    private Validator validator;

    /**
     * Method under test: {@link SystemHandler#processBody(LoginRequest, ServerRequest)}
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

        LoginRequest loginRequest = new LoginRequest("42", "42", "User Secret");

        systemHandler.processBody(loginRequest,
                new ServerRequestWrapper(new ServerRequestWrapper(new ServerRequestWrapper(new ServerRequestWrapper(null)))));
    }

    /**
     * Method under test: {@link SystemHandler#processBody(LoginRequest, ServerRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessBody2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI.authenticate(String, String, String)" is null
        //       at com.github.godwinpinto.authable.application.rest.auth.controller.SystemHandler.processBody(SystemHandler.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        when(authServiceAPI.authenticate(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(null);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getSystemId()).thenReturn("42");
        when(loginRequest.getUserId()).thenReturn("42");
        when(loginRequest.getUserSecret()).thenReturn("User Secret");
        systemHandler.processBody(loginRequest, new ServerRequestWrapper(new ServerRequestWrapper(
                new ServerRequestWrapper(new ServerRequestWrapper(mock(ServerRequestWrapper.class))))));
    }

    /**
     * Method under test: {@link SystemHandler#processBody(LoginRequest, ServerRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessBody3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.onErrorResume(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.application.rest.auth.controller.SystemHandler.processBody(SystemHandler.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        when(authServiceAPI.authenticate(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(mock(Mono.class));
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getSystemId()).thenReturn("42");
        when(loginRequest.getUserId()).thenReturn("42");
        when(loginRequest.getUserSecret()).thenReturn("User Secret");
        systemHandler.processBody(loginRequest, new ServerRequestWrapper(new ServerRequestWrapper(
                new ServerRequestWrapper(new ServerRequestWrapper(mock(ServerRequestWrapper.class))))));
    }
}

