package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException implements Codable {

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public HttpStatus getStatus() {
        return errorCode.getStatus();
    }

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }

    @Override
    public boolean getIsNotify() {
        return errorCode.getIsNotify();
    }
}
