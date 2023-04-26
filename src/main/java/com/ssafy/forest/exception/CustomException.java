package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private Codable codable;

    public CustomException(Codable codable) {
        this.codable = codable;
    }

    public Codable getCodable() {
        return codable;
    }
}
