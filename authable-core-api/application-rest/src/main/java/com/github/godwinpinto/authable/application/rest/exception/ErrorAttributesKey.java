package com.github.godwinpinto.authable.application.rest.exception;

import lombok.Getter;

@Getter
public enum ErrorAttributesKey {
  STATUS("status"),
  MESSAGE("message");

  private final String key;

  ErrorAttributesKey(String key) {
    this.key = key;
  }
}