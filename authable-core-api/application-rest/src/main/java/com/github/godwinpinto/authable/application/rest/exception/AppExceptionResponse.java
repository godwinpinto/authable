package com.github.godwinpinto.authable.application.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppExceptionResponse {

  private Integer code;
  private String message;
}