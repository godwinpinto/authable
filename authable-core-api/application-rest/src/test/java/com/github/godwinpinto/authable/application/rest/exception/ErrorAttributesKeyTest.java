package com.github.godwinpinto.authable.application.rest.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class ErrorAttributesKeyTest {

  @Test
  void testEnum() {
    assertEquals("code", ErrorAttributesKey.CODE.getKey());
    assertEquals("message", ErrorAttributesKey.MESSAGE.getKey());
  }
}
