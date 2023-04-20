package com.github.godwinpinto.authable.application.rest.auth.controller;

import com.github.godwinpinto.authable.application.rest.auth.json.ApiResponse;
import com.github.godwinpinto.authable.application.rest.auth.json.LoginRequest;
import com.github.godwinpinto.authable.application.rest.totp.controller.WebFluxSecurityConfig;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import javax.naming.AuthenticationException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Import({
        SystemRoutesConfig.class,
        WebFluxSecurityConfig.class
})
@WebFluxTest
@ContextConfiguration(classes = {SystemHandler.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "36000")
public class SystemHandlerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private AuthServiceAPI authServiceAPI;

    @Autowired
    Validator validator;

    @Test
    public void systemLoginSuccessful_Test() {

        LoginRequest loginRequest = LoginRequest.builder()
                .systemId("NETBK")
                .userId("TESTUSER")
                .userSecret("Test@1234")
                .build();

        UserDto userDto = UserDto.builder()
                .username("ACCESS_ID")
                .password("JWTTOKEN")
                .roles(List.of(Role.ROLE_ADMIN))
                .expiryTime(0)
                .build();

        when(authServiceAPI.authenticate(loginRequest.getSystemId(), loginRequest.getUserId(),
                loginRequest.getUserSecret())).thenReturn(Mono.just(userDto));

        webClient
                .post()
                .uri("/auth/login")
                .bodyValue(loginRequest)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.accessToken")
                .isEqualTo("JWTTOKEN")

        ;
    }


    @Test
    public void systemLoginError_Test() {

        LoginRequest loginRequest = LoginRequest.builder()
                .systemId("NETBK")
                .userId("TESTUSER")
                .userSecret("Test@1234")
                .build();

        UserDto userDto = UserDto.builder()
                .username("ACCESS_ID")
                .password("JWTTOKEN")
                .roles(List.of(Role.ROLE_ADMIN))
                .expiryTime(0)
                .build();

        when(authServiceAPI.authenticate(anyString(), anyString(),
                anyString())).thenReturn(Mono.error(new AuthenticationException("Invalid Credentials")));

        webClient
                .post()
                .uri("/auth/login")
                .bodyValue(loginRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(ApiResponse.class)

        ;
    }

    @Test
    public void systemLogin_withNoParameters_Test() {

        //IssueTokenRequest issueTokenRequest = IssueTokenRequest.builder().systemId("CARDS").systemSecret("1234").build();
        when(authServiceAPI.authenticate("", "", "")).thenReturn(Mono.empty());

        webClient
                .post()
                .uri("/auth/login")
                //.bodyValue(issueTokenRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(ApiResponse.class)
        ;
    }

    @Test
    public void systemLogin_withNoSecret_Test() {

        LoginRequest loginRequest = LoginRequest.builder()
                .systemId("CARDS")
                .userId("TESTUSER")
                .userSecret("")
                .build();
        when(authServiceAPI.authenticate("", "", "")).thenReturn(Mono.empty());

        webClient
                .post()
                .uri("/auth/login")
                //.bodyValue(issueTokenRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(ApiResponse.class)
        ;
    }

    @Test
    public void systemLogin_withNoSystemId_Test() {

        LoginRequest loginRequest = LoginRequest.builder()
                .systemId("")
                .userId("123")
                .userSecret("1234")
                .build();

        when(authServiceAPI.authenticate(anyString(), anyString(), anyString())).thenReturn(Mono.empty());
        webClient
                .post()
                .uri("/auth/login")
                //.bodyValue(issueTokenRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(ApiResponse.class)
        ;

    }

    @Test
    public void systemLogin_withNoUserId_Test() {

        LoginRequest loginRequest = LoginRequest.builder()
                .systemId("NETBK")
                .userId("")
                .userSecret("Test@1234")
                .build();

        when(authServiceAPI.authenticate(anyString(), anyString(), anyString())).thenReturn(Mono.empty());
        webClient
                .post()
                .uri("/auth/login")
                //.bodyValue(issueTokenRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(ApiResponse.class)
        ;

    }
}
