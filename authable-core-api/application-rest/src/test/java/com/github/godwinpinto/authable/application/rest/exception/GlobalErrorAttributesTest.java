package com.github.godwinpinto.authable.application.rest.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.application.rest.auth.controller.SystemHandler;
import com.github.godwinpinto.authable.application.rest.auth.controller.SystemRoutesConfig;
import com.github.godwinpinto.authable.application.rest.auth.json.LoginRequest;
import com.github.godwinpinto.authable.application.rest.config.SecurityConfig;
import com.github.godwinpinto.authable.application.rest.totp.controller.WebFluxSecurityConfig;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Import({DummyRoutesConfig.class, SystemRoutesConfig.class, WebFluxSecurityConfig.class})
@WebFluxTest
@ContextConfiguration(classes = {GlobalErrorAttributes.class, GlobalErrorWebExceptionHandler.class, SystemHandler.class,
    SecurityConfig.class, DummyUnauthorizedHandler.class, DummyResponseStatusHandler.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "36000")
class GlobalErrorAttributesTest {

  @Autowired
  Validator validator;
  @Autowired
  private WebTestClient webClient;
  @MockBean
  private AuthServiceAPI authServiceAPI;

  @Test
  void systemLoginSuccessful_Test() {

    LoginRequest loginRequest =
        LoginRequest.builder().systemId("NETBK").userId("TESTUSER").userSecret("Test@1234").build();

    UserDto userDto =
        UserDto.builder()
            .username("ACCESS_ID")
            .password("JWTTOKEN")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();

    when(authServiceAPI.authenticate(
        loginRequest.getSystemId(), loginRequest.getUserId(), loginRequest.getUserSecret()))
        .thenReturn(Mono.just(userDto));

    webClient
        .post()
        .uri("/auth/login")
        .bodyValue(loginRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.accessToken")
        .isEqualTo("JWTTOKEN");
  }

  @Test
  void systemLoginFailForGet_Test() {
    webClient
        .get()
        .uri("/auth/login")
        //.bodyValue(loginRequest)
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectBody()
        .jsonPath("$.code")
        .isEqualTo(404);
  }

  @Test
  void unknownUrlFailForGet_Test() {
    webClient
        .get()
        .uri("/test")
        //.bodyValue(loginRequest)
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectBody()
        .jsonPath("$.code")
        .isEqualTo(404);
  }

  @Test
  void unknownUrlInsideAuthFailForPost_Test() {
    LoginRequest loginRequest =
        LoginRequest.builder().systemId("NETBK").userId("TESTUSER").userSecret("Test@1234").build();

    UserDto userDto =
        UserDto.builder()
            .username("ACCESS_ID")
            .password("JWTTOKEN")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();

    when(authServiceAPI.authenticate(
        loginRequest.getSystemId(), loginRequest.getUserId(), loginRequest.getUserSecret()))
        .thenReturn(Mono.just(userDto));

    webClient
        .post()
        .uri("/auth/login/test")
        .bodyValue(loginRequest)
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectBody()
        .jsonPath("$.code")
        .isEqualTo(404);
  }


  @Test
  void dummyHandlerForCustomExceptionList_Test() {

    webClient
        .post()
        .uri("/dummy-unauthorized")
        .exchange()
        .expectStatus()
        .isUnauthorized()
        .expectBody()
        .jsonPath("$.code")
        .isEqualTo(401);
  }

  @Test
  void dummyHandlerForResponseStatusException_Test() {

    webClient
        .post()
        .uri("/dummy-response-status")
        .exchange()
        .expectStatus()
        .isForbidden()
        .expectBody()
        .jsonPath("$.code")
        .isEqualTo(403);
  }


  @Test
  void determineHttpStatus_Test() {

    GlobalErrorAttributes globalErrorAttributes = new GlobalErrorAttributes();
    RuntimeException re = new RuntimeException("Test");
    ResponseStatusException rse = new ResponseStatusException(HttpStatus.FORBIDDEN);
    UnAuthorizedException uae = new UnAuthorizedException();

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, globalErrorAttributes.determineHttpStatus(re));
    assertEquals(HttpStatus.FORBIDDEN, globalErrorAttributes.determineHttpStatus(rse));
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, globalErrorAttributes.determineHttpStatus(uae));
  }

}
