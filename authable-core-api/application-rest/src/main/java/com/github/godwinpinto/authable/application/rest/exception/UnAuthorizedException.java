package com.github.godwinpinto.authable.application.rest.exception;

public class UnAuthorizedException extends RuntimeException {

  private String message;

  public UnAuthorizedException(String message) {
    super(message);
    this.message = message;
  }

  public UnAuthorizedException() {
  }
}