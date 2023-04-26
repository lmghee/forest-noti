package com.ssafy.forestnoti.exception;

import org.springframework.http.HttpStatus;

public interface Codable {
    String getMessage();
    HttpStatus getStatus();
}
