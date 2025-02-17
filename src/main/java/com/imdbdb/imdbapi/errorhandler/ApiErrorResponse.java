package com.imdbdb.imdbapi.errorhandler;


import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

//Error object to add more error details
@Getter
public class ApiErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String message;
    private final String error;
    private List<String> details;

    public ApiErrorResponse(int status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public ApiErrorResponse(int status, String error, String message, List<String> details) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.error = error;
        this.details = details;
    }

}
