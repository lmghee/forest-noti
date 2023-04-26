package com.ssafy.forest.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.forest.exception.Codable;
import com.ssafy.forest.exception.CustomException;
import com.ssafy.forest.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Getter
@Setter
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime timeStamp;
    private int code;
    private String status;
    private String path;
    private ErrorContent error;

    public ErrorResponse(CustomException e, String path) {
        this.timeStamp = ZonedDateTime.now(TimeZone.getTimeZone("Asia/Seoul").toZoneId());
        this.code = e.getCodable().getStatus().value();
        this.status = e.getCodable().getStatus().name();
        this.path = path;
        this.error = new ErrorContent(e.getCodable().getMessage());
    }

}
