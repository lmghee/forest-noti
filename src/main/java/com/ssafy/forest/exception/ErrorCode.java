package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements Codable {
    TEST_OK_NOTIFY(HttpStatus.NOT_FOUND, "MM이 갑니다", true),
    TEST_NO_NOTIFY(HttpStatus.NOT_FOUND, "MM이 안갑니다", false),
    ;

    private final HttpStatus status;
    private final String message;
    private final boolean isNotify;

    ErrorCode(HttpStatus status, String message, boolean isNotify) {
        this.status = status;
        this.message = message;
        this.isNotify = isNotify;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getIsNotify() {
        return isNotify;
    }

}
