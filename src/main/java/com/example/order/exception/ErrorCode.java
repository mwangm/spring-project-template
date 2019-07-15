package com.example.order.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    VALIDATION_FAILED(1000, "Request validation failed"),
    BAD_REQUEST(1002, "Bad request"),
    SERVER_ERROR(1001, "Internal Server error"),
    NOT_FOUND(1002, "Not found");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
