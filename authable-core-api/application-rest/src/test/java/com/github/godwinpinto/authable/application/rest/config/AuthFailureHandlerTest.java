package com.github.godwinpinto.authable.application.rest.config;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.godwinpinto.authable.application.rest.auth.json.ApiResponse;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;

class AuthFailureHandlerTest {
  /** Method under test: {@link AuthFailureHandler#formatResponse(ServerHttpResponse)} */
  @Test
  void testFormatResponse() {
    AuthFailureHandler authFailureHandler = new AuthFailureHandler();
    authFailureHandler.formatResponse(new MockServerHttpResponse());
  }

  /** Method under test: {@link AuthFailureHandler#formatResponse(ServerHttpResponse)} */
  @Test
  void testFormatResponse2() {

    AuthFailureHandler authFailureHandler = new AuthFailureHandler();
    authFailureHandler.formatResponse(new HttpHeadResponseDecorator(new MockServerHttpResponse()));
  }

  @Test
  void testFormatResponse3() throws JsonProcessingException {
    AuthFailureHandler authFailureHandler = spy(new AuthFailureHandler());
    doThrow(JsonProcessingException.class)
        .when(authFailureHandler)
        .writeObjectToString(any(ApiResponse.class));
    MockServerHttpResponse httpResponse = new MockServerHttpResponse();
    httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
    HttpHeadResponseDecorator head = new HttpHeadResponseDecorator(httpResponse);

    authFailureHandler.formatResponse(head);
  }

  /** Method under test: {@link AuthFailureHandler#formatResponse(ServerHttpResponse)} */
  @Test
  void testFormatResponse4() {
    AuthFailureHandler authFailureHandler = new AuthFailureHandler();
    HttpHeadResponseDecorator response = mock(HttpHeadResponseDecorator.class);
    ChannelSendOperator<Object> channelSendOperator =
        new ChannelSendOperator<>(mock(Publisher.class), mock(Function.class));

    when(response.writeWith(Mockito.<Publisher<DataBuffer>>any())).thenReturn(channelSendOperator);
    when(response.bufferFactory()).thenReturn(new DefaultDataBufferFactory());
    when(response.getHeaders()).thenReturn(new HttpHeaders());
    assertSame(channelSendOperator, authFailureHandler.formatResponse(response));
    verify(response).writeWith(Mockito.<Publisher<DataBuffer>>any());
    verify(response).bufferFactory();
    verify(response).getHeaders();
  }
}
