package com.ssafy.forest.controller;

import com.ssafy.forest.exception.CustomException;
import com.ssafy.forest.mattermost.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    private NotificationManager notificationManager;

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(CustomException e, HttpServletRequest req) {
        String resquestUrl = req.getRequestURI();
        if(e.getIsNotify())
            notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));

        return ResponseEntity.of(Optional.of("hi"));
    }


    private String getParams(HttpServletRequest req) {
        StringBuilder params = new StringBuilder();
        Enumeration<String> keys = req.getParameterNames();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            params.append("- ").append(key).append(" : ").append(req.getParameter(key)).append('\n');
        }

        return  params.toString();
    }
}