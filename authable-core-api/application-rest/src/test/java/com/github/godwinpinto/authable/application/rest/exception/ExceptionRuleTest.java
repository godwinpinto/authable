package com.github.godwinpinto.authable.application.rest.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


class ExceptionRuleTest {

  @Test
  void testRecord() {

    Class<UnAuthorizedException> exceptionClass = UnAuthorizedException.class;
    HttpStatus status = HttpStatus.BAD_REQUEST;

    ExceptionRule er = new ExceptionRule(exceptionClass, status);
    assertEquals(exceptionClass, er.exceptionClass());
    assertEquals(status, er.status());
  }
}
