package com.lewns2.backend.rest.controller;

import com.lewns2.backend.rest.exception.ExceptionResponse;
import com.lewns2.backend.rest.exception.badrequest.InvalidValueException;
import com.lewns2.backend.rest.exception.notfound.NotFoundException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Getter
public class GlobalExceptionHandler {

    private static final String LOG_FORMAT = "Class : {}, Code : {}, Message : {}";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(final NotFoundException e) {
        log.info(LOG_FORMAT, e.getClass().getSimpleName(), e.getErrorCode().getValue(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionResponse.from(e));
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidValueException(final InvalidValueException e) {
        log.info(LOG_FORMAT, e.getClass().getSimpleName(), e.getErrorCode().getValue(), e.getMessage());
        return ResponseEntity.badRequest().body(ExceptionResponse.from(e));
    }
}
