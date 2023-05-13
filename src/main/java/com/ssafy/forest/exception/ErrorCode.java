package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements Codable {

    AUTH_EXPIRED_TOKEN(HttpStatus.FORBIDDEN, "Access Token 기한이 만료되었습니다.", true),
    AUTH_WRONG_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다.", true),
    TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "토큰이 없습니다.", true),
    SECRET_KEY_EMPTY(HttpStatus.SERVICE_UNAVAILABLE, "jwt secret key가 없습니다.", true),
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
