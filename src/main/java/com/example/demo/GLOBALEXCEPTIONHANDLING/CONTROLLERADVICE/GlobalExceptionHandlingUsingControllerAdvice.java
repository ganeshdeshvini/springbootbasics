package com.example.demo.GLOBALEXCEPTIONHANDLING.CONTROLLERADVICE;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlingUsingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> genericException(final Exception e) {
        System.out.println("GENERIC EXCEPTION using @ControllerAdvice");
        e.printStackTrace();
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<String> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(message, httpStatus);
    }
}
