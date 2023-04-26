package com.ssafy.forest.controller;

import com.ssafy.forest.exception.CustomException;
import com.ssafy.forest.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public void sad() {
        System.out.println("맞아요");
        throw new CustomException(ErrorCode.AUTH_USER_NOT_FOUND);
    }
}
