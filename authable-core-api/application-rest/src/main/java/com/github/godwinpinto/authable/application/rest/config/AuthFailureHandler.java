package com.github.godwinpinto.authable.application.rest.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.godwinpinto.authable.application.rest.auth.json.ApiResponse;
import java.nio.charset.StandardCharsets;
import lombok.NoArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

@NoArgsConstructor
public class AuthFailureHandler {

  private ObjectMapper mapperMock;

  protected String writeObjectToString(ApiResponse apiResponse) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(apiResponse);
  }

  public Mono<Void> formatResponse(ServerHttpResponse response) {
    response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    HttpStatusCode httpStatusCode = response.getStatusCode();
    int code = 0;
    if (httpStatusCode != null) {
      code = httpStatusCode.value();
    } else {
      code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
    ApiResponse apiResponse = new ApiResponse(code, "Access Denied", null);
    StringBuilder json = new StringBuilder();
    try {
      json.append(writeObjectToString(apiResponse));
    } catch (JsonProcessingException jsonProcessingException) {
      json.append("{\"error\":\"Unable to format response\"}");
    }

    String responseBody = json.toString();
    byte[] bytes = responseBody.getBytes(StandardCharsets.UTF_8);
    DataBuffer buffer = response.bufferFactory().wrap(bytes);
    return response.writeWith(Mono.just(buffer));
  }
}
