package com.github.godwinpinto.authable.application.rest.validator;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.application.rest.totp.controller.WebFluxSecurityConfig;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {DummyHandlerWithoutRequestBody.class})
@ExtendWith(SpringExtension.class)
@WebFluxTest // to autowire validator
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureWebTestClient(timeout = "360000")
@Import({WebFluxSecurityConfig.class})
class AbstractValidationHandlerTest {

  @Autowired Validator validator;

  @MockBean AuthServiceAPI authServiceAPI;

  DisposableServer disposableServer;

  @Autowired WebTestClient webTestClient;

  @BeforeAll
  void setupStart() {
    DummyHandlerWithoutRequestBody dummyHandlerWithoutRequestBody =
        new DummyHandlerWithoutRequestBody(null, authServiceAPI);
    DummyHandlerWithRequestBody dummyHandlerWithRequestBody =
        new DummyHandlerWithRequestBody(validator, authServiceAPI);
    ReactorHttpHandlerAdapter adapter =
        new ReactorHttpHandlerAdapter(
            RouterFunctions.toHttpHandler(
                dummyHandlerWithoutRequestBody
                    .doSomething()
                    .and(dummyHandlerWithRequestBody.doSomething())));
    HttpServer server = HttpServer.create().host("localhost").port(8080).handle(adapter);

    this.disposableServer = server.bindNow();

    webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
  }

  @AfterAll
  void setupShutDown() {
    disposableServer.disposeNow();
  }

  @Test
  void emptyRequestClass_Test() {

    UserDto userDto = UserDto.builder().build();
    doReturn(Mono.just(userDto))
        .when(authServiceAPI)
        .authenticate(anyString(), anyString(), anyString());

    webTestClient
        .post()
        .uri("/test-no-request-body")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("200")
        .jsonPath("$.statusDescription")
        .isEqualTo("Success");
  }

  @Test
  void existsClass_EmptyFields_Test() {

    UserDto userDto = UserDto.builder().build();
    doReturn(Mono.just(userDto))
        .when(authServiceAPI)
        .authenticate(anyString(), anyString(), anyString());

    GenericRequest genericRequest = new GenericRequest();

    webTestClient
        .post()
        .uri("/test-with-request-body")
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("300")
        .jsonPath("$.statusDescription")
        .isEqualTo("User Id cannot be empty");
  }

  @Test
  void existsClass_NoBody_Test() {

    UserDto userDto = UserDto.builder().build();
    doReturn(Mono.just(userDto))
        .when(authServiceAPI)
        .authenticate(anyString(), anyString(), anyString());

    webTestClient
        .post()
        .uri("/test-with-request-body")
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("300")
        .jsonPath("$.statusDescription")
        .isEqualTo("Invalid Parameters in request");
  }

  @Test
  void existsClass_PresentFieldValues_Test() {

    UserDto userDto = UserDto.builder().build();
    doReturn(Mono.just(userDto))
        .when(authServiceAPI)
        .authenticate(anyString(), anyString(), anyString());

    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("TEST_USER");

    webTestClient
        .post()
        .uri("/test-with-request-body")
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("200")
        .jsonPath("$.statusDescription")
        .isEqualTo("Success");
  }

  @Test
  void existsClass_PresentFieldValues_OtherException_Test() {

    UserDto userDto = UserDto.builder().build();
    doReturn(Mono.error(new RuntimeException("Some Runtime Exception")))
        .when(authServiceAPI)
        .authenticate(anyString(), anyString(), anyString());

    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("TEST_USER");

    webTestClient
        .post()
        .uri("/test-with-request-body")
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.code")
        .isEqualTo("400")
        .jsonPath("$.message")
        .isEqualTo("Some Runtime Exception");
  }

  @Test
  void onValidationErrors_Else_Test() {
    DummyHandlerWithoutRequestBody dummyHandlerWithoutRequestBody =
        new DummyHandlerWithoutRequestBody(null, authServiceAPI);

    List<ObjectError> lst = new ArrayList<>(0);

    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("TEST_USER");
    Errors errors = new BeanPropertyBindingResult(genericRequest, GenericRequest.class.getName());

    StepVerifier.create(dummyHandlerWithoutRequestBody.onValidationErrors(errors))
        .expectErrorMatches(exception -> exception instanceof ResponseStatusException)
        .verify();
  }

  @Test
  void onValidationErrors_If_Test() {
    DummyHandlerWithoutRequestBody dummyHandlerWithoutRequestBody =
        new DummyHandlerWithoutRequestBody(null, authServiceAPI);

    GenericRequest genericRequest = new GenericRequest();
    Errors errors = new BeanPropertyBindingResult(genericRequest, GenericRequest.class.getName());
    this.validator.validate(genericRequest, errors);
    StepVerifier.create(dummyHandlerWithoutRequestBody.onValidationErrors(errors))
        .expectErrorMatches(exception -> exception instanceof ResponseStatusException)
        .verify();
  }
}
