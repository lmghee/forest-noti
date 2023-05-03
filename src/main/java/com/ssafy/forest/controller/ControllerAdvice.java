package com.ssafy.forest.controller;

import com.ssafy.forest.exception.CustomException;
import com.ssafy.forest.exception.ErrorCode;
import com.ssafy.forest.exception.dto.ErrorResponse;
import com.ssafy.forest.mattermost.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.Enumeration;
import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    private NotificationManager notificationManager;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> exceptionHandler(CustomException e, HttpServletRequest req) {
        String resquestUrl = req.getRequestURI();

        if(e.getCodable().getIsNotify()) {
            notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
        }

        ErrorResponse errorResponse = new ErrorResponse(e, req.getRequestURI());
        return new ResponseEntity<>(errorResponse, e.getCodable().getStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionTest(Exception e, HttpServletRequest req) throws Exception {
        e.printStackTrace();
        if (e instanceof AccessDeniedException || e instanceof AuthenticationException) {
            throw e;
        }
        notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> bindingTest(MethodArgumentNotValidException e, HttpServletRequest req) {
        e.printStackTrace();
        notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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