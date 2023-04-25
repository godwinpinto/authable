package com.github.godwinpinto.authable.application.rest.totp.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.application.rest.totp.json.VerifyTOtpRequest;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpVerifyDto;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

@Import({TOtpRoutesConfig.class, WebFluxSecurityConfig.class})
@WebFluxTest
@ContextConfiguration(classes = {TOtpVerifyHandler.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "36000")
class TOtpVerifyHandlerTest {
  @MockBean TOtpUserServiceAPI tOtpUserServiceAPI;
  @MockBean FetchPrincipalComponent fetchPrincipalComponent;
  @Autowired TOtpVerifyHandler tOtpVerifyHandler;
  @MockBean TOtpUnSubscribeHandler tOtpUnSubscribeHandler;
  @MockBean TOtpUnBlockHandler tOtpUnBlockHandler;
  @MockBean TOtpSubscribeHandler tOtpSubscribeHandler;
  @MockBean TOtpGenerateQrHandler tOtpGenerateQrHandler;
  @Autowired Validator validator;
  @Autowired private WebTestClient webClient;
  @MockBean private TOtpStatusHandler tOtpStatusHandler;

  @Test
  void processBody_NoSubscription_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();
    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString())).thenReturn(Mono.empty());

    VerifyTOtpRequest verifyTOtpRequest =
        VerifyTOtpRequest.builder().userId("TEST_USER").otp("123456").build();

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .isEqualTo("No active subscription")
        .jsonPath("$.statusCode")
        .isEqualTo("300");
  }

  @Test
  void processBody_Subscribed_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();

    TOtpVerifyDto tOtpUserStatusDto =
        TOtpVerifyDto.builder().statusCode("200").statusDescription("Verification success").build();

    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString()))
        .thenReturn(Mono.just(tOtpUserStatusDto));

    VerifyTOtpRequest verifyTOtpRequest =
        VerifyTOtpRequest.builder().userId("TEST_USER").otp("123456").build();

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .isEqualTo("Verification success")
        .jsonPath("$.statusCode")
        .isEqualTo("200");
  }

  @Test
  void processBody_EmptyInputField_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();
    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString())).thenReturn(Mono.empty());
    VerifyTOtpRequest verifyTOtpRequest = VerifyTOtpRequest.builder().build();

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .value(Matchers.in(List.of("User Id cannot be empty", "OTP cannot be empty")))
        .jsonPath("$.statusCode")
        .isEqualTo("300");
  }

  @Test
  void processBody_NoUserIdField_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();
    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString())).thenReturn(Mono.empty());
    VerifyTOtpRequest verifyTOtpRequest = VerifyTOtpRequest.builder().otp("123456").build();

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .isEqualTo("User Id cannot be empty")
        .jsonPath("$.statusCode")
        .isEqualTo("300");
  }

  @Test
  void processBody_NoOtpField_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();
    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString())).thenReturn(Mono.empty());
    VerifyTOtpRequest verifyTOtpRequest = VerifyTOtpRequest.builder().userId("TEST_USER").build();

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .isEqualTo("OTP cannot be empty")
        .jsonPath("$.statusCode")
        .isEqualTo("300");
  }

  @Test
  void processBody_NoInput_Test() {

    UserDto userDto =
        UserDto.builder()
            .username("TEST_USER")
            .systemId("TEST_SYSTEM")
            .roles(List.of(Role.ROLE_ADMIN))
            .expiryTime(0)
            .build();
    when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
    when(tOtpUserServiceAPI.verify(anyString(), anyString(), anyString())).thenReturn(Mono.empty());

    webClient
        .post()
        .uri("/totp/verify")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("statusDescription")
        .isEqualTo("Invalid Parameters in request")
        .jsonPath("$.statusCode")
        .isEqualTo("300");
  }
}
