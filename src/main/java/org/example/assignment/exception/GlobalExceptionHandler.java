package org.example.assignment.exception;

import org.example.assignment.config.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {StudentException.class})
  public ResponseEntity<?> handleBadRequestException(StudentException e) {
    Logger.getInstance().log("Something wrong when attempting to call API: " + e.getMessage());
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
