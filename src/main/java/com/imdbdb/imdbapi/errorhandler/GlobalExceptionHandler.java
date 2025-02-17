package com.imdbdb.imdbapi.errorhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


//Global error handler
@RestControllerAdvice
public class GlobalExceptionHandler {

    //handles validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField()  + ": " + error.getDefaultMessage())
                .toList();

        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                "Invalid request parameters",
                errors
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Handles resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> resourceNotFound(ResourceNotFoundException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Handles unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                e.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
