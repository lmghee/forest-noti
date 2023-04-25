package com.ssafy.forestnoti.exception;

import org.springframework.http.HttpStatus;

public class CustomException {

    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    private CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, HttpStatus status) {
        this.errorCode = errorCode;
        this.httpStatus = status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
