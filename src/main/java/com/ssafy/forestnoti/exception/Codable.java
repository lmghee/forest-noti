package com.ssafy.forestnoti.exception;

import org.springframework.http.HttpStatus;

public interface Codable {
    HttpStatus getMessage();
    String getStatus();
}
