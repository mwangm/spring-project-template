package com.example.order.exception;

import lombok.Getter;

public class HttpException extends RuntimeException {
    @Getter
    private ErrorCode errorCode;

    public HttpException(ErrorCode code, String message) {
        super(message);
        this.errorCode = code;
    }

    public HttpException(ErrorCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this.errorCode = code;
    }

    public HttpException(ErrorCode code) {
        this(code, code.getMessage());
    }
}
