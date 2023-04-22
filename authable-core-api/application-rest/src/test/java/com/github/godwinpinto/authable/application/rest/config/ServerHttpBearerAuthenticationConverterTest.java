package com.github.godwinpinto.authable.application.rest.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.test.StepVerifier;

@ContextConfiguration(
    classes = {
      SecurityContextRepository.class,
    })
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServerHttpBearerAuthenticationConverterTest {
  ServerHttpBearerAuthenticationConverter serverHttpBearerAuthenticationConverter;
  @MockBean AuthenticationManager authenticationManager;
  @MockBean private AuthServiceAPI authServiceAPI;

  @BeforeAll
  void setup() {
    serverHttpBearerAuthenticationConverter =
        new ServerHttpBearerAuthenticationConverter(authServiceAPI);
  }

  @Test
  void convert_Test() {
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.set("Authorization", "Bearer TEST_JWT_TOKEN");

    MockServerHttpRequest request =
        MockServerHttpRequest.get("/path")
            .headers(headers) // .header("Authorization", "Bearer TEST_JWT_TOKEN")
            .build();
    String sampleToken = "TEST_TOKEN";
    Map<String, Object> mapClaims = new HashMap<>();
    mapClaims.put("sub", "TEST_USER_ID");
    mapClaims.put(ApplicationConstants.JWT_ROLE_KEY, List.of("ROLE_ADMIN"));
    mapClaims.put(ApplicationConstants.JWT_SYSTEM_ID_KEY, "TEST_SYSTEM");

    MockServerHttpResponse response = new MockServerHttpResponse();
    ServerWebExchange exchange = MockServerWebExchange.from(request);
    doReturn(true).when(authServiceAPI).validateToken(anyString());
    doReturn(mapClaims).when(authServiceAPI).getClaims(anyString());
    StepVerifier.create(serverHttpBearerAuthenticationConverter.convert(exchange))
        .assertNext(
            authentication -> {
              assertEquals("TEST_USER_ID", ((UserDto) authentication.getPrincipal()).getUsername());
            })
        .verifyComplete();
  }

  @Test
  void convert_IncorrectBearerLength_Test() {
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.set("Authorization", "");

    MockServerHttpRequest request =
        MockServerHttpRequest.get("/path")
            .headers(headers) // .header("Authorization", "Bearer TEST_JWT_TOKEN")
            .build();
    String sampleToken = "TEST_TOKEN";
    Map<String, Object> mapClaims = new HashMap<>();
    mapClaims.put("sub", "TEST_USER_ID");
    mapClaims.put(ApplicationConstants.JWT_ROLE_KEY, List.of("ROLE_ADMIN"));
    mapClaims.put(ApplicationConstants.JWT_SYSTEM_ID_KEY, "TEST_SYSTEM");

    MockServerHttpResponse response = new MockServerHttpResponse();
    ServerWebExchange exchange = MockServerWebExchange.from(request);
    doReturn(true).when(authServiceAPI).validateToken(anyString());
    doReturn(mapClaims).when(authServiceAPI).getClaims(anyString());
    StepVerifier.create(serverHttpBearerAuthenticationConverter.convert(exchange)).verifyComplete();
  }
}
