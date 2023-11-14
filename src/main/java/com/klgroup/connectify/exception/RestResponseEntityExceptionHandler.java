package com.klgroup.connectify.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = { CustomException.class })
    protected ResponseEntity<Object> handleConflict(
            CustomException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @ExceptionHandler(value
            = { AccessDeniedException.class })
    protected ResponseEntity<Object> handleConflict(
            AccessDeniedException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Access denied",
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Something went wrong",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}