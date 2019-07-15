package com.example.order.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorMessage {

    private int code;

    private String message;

    private Map<String, String> errors;

    public ErrorMessage(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
        errors = new HashMap<>();
    }

    public ErrorMessage withDetails(Map<String, String> fieldErrors) {
        errors = fieldErrors;
        return this;
    }
}
