package com.ssafy.forestnoti.controller;

import com.ssafy.forestnoti.exception.CustomException;
import com.ssafy.forestnoti.exception.ErrorCode;
import com.ssafy.forestnoti.mattermost.NotificationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public void js() {
        throw new CustomException(ErrorCode.AUTH_USER_NOT_FOUND);
    }
}
