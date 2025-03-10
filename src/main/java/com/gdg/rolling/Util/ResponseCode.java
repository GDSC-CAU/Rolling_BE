package com.gdg.rolling.Util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "잘못된 요청입니다."),
    ;
    private final HttpStatus httpStatus;
    private final Boolean success;
    private final String message;

    ResponseCode(HttpStatus httpStatus, Boolean success, String message) {
        this.httpStatus = httpStatus;
        this.success = success;
        this.message = message;
    }
}
