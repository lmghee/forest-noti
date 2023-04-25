package com.ssafy.forestnoti.exception;

import org.springframework.http.HttpStatus;

enum ErrorCode implements Codable {
    AUTH_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "찾을 수 없는 유저입니다."),
    ;

    private final HttpStatus message;
    private final String status;

    ErrorCode(HttpStatus message, String status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public HttpStatus getMessage() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
