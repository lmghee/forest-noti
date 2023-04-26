package com.ssafy.forest.exception;

import org.springframework.http.HttpStatus;

public interface Codable {

    String getMessage();
    HttpStatus getStatus();

}
