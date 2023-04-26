package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements Codable {
    AUTH_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "뭐요"),
    ;

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
