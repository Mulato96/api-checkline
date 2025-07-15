package com.sico.api.checkinline.application.exceptions;

import com.sico.api.checkinline.application.components.MessageTranslator;
import com.sico.api.checkinline.domain.models.Error;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class GlobalExceptionHandler {

  private final MessageTranslator message;

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleAllExceptions(Exception ex, HttpServletRequest request) {
    return mapMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, message.getMessage("internal.server.exception"),
        Objects.requireNonNull(ex.getMessage()));
  }

  @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class, BadRequestException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleBadRequestException(ResponseStatusException ex, HttpServletRequest request) {
    return mapMessage(request, (HttpStatus) ex.getStatusCode(), message.getMessage("bad.request.exception"),
        Objects.requireNonNull(ex.getReason()));
  }

  @ExceptionHandler({VerificationLaftException.class, ExcelProcessException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleBadRequestExceptionCustom(ResponseStatusException ex,
      HttpServletRequest request) {
    return mapMessage(request, (HttpStatus) ex.getStatusCode(), message.getMessage(ex.getReason()),
        Objects.requireNonNull(ex.getMessage()));
  }

  @ExceptionHandler({NotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleNotFoundException(ResponseStatusException ex, HttpServletRequest request) {
    return mapMessage(request, (HttpStatus) ex.getStatusCode(), ex.getBody().getTitle(),
        Objects.requireNonNull(ex.getReason()));
  }

  private Error mapMessage(HttpServletRequest request, HttpStatus status, String error, Object errors) {
    return new Error(status.value(), error, errors, request.getRequestURI());
  }


}
