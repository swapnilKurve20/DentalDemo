package com.sample.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionController {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public String handleConstraintViolation(DataIntegrityViolationException ex) {
    log.debug("Constraint violation exception encountered: {}", ex.getMessage(), ex);
    if (ex.getRootCause() != null
        && ex.getRootCause().getMessage() != null
        && ex.getRootCause().getMessage().contains("prevent_duplicate_appointment")) {
      return "slot is currently booked, please try another slot";
    }
    return "Failed to save data";
  }
}