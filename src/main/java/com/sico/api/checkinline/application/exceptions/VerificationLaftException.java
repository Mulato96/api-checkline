package com.sico.api.checkinline.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VerificationLaftException extends ResponseStatusException {
  public VerificationLaftException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }
}
