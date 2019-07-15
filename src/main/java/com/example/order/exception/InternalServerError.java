package com.example.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerError extends HttpException {

    public InternalServerError(Throwable cause) {
        super(ErrorCode.SERVER_ERROR, cause);
    }
}
