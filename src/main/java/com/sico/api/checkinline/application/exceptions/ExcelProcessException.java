package com.sico.api.checkinline.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExcelProcessException extends ResponseStatusException {

  public ExcelProcessException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }
}
