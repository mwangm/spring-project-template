package com.example.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("error[{}]: {}", ErrorCode.VALIDATION_FAILED.getCode(), exception.getMessage());
        Map<String, String> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (k1, k2) -> k1));
        return new ErrorMessage(ErrorCode.VALIDATION_FAILED).withDetails(fieldErrors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException exception) {
        log.error("error[{}]: {}", ErrorCode.VALIDATION_FAILED.getCode(), exception.getMessage());
        Map<String, String> fieldErrors = exception.getConstraintViolations().stream()
                .collect(Collectors.toMap(e -> ((PathImpl) e.getPropertyPath()).getLeafNode().toString(),
                        ConstraintViolation::getMessage, (k1, k2) -> k1));
        return new ErrorMessage(ErrorCode.VALIDATION_FAILED).withDetails(fieldErrors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleHttpClientError(IllegalArgumentException ex) {
        log.warn("invalid request", ex);
        return new ErrorMessage(ErrorCode.BAD_REQUEST.getCode(), ex.getMessage());
    }

    @ExceptionHandler(HttpException.class)
    @ResponseBody
    public ResponseEntity handleHttpException(HttpException ex) {
        ResponseStatus responseStatus = ex.getClass().getDeclaredAnnotation(ResponseStatus.class);
        log.warn(String.format("http exception code %s", responseStatus), ex);
        return ResponseEntity.status(responseStatus.value())
                .body(new ErrorMessage(ex.getErrorCode().getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleException(Exception ex) {
        log.warn("request exception", ex);
        return new ErrorMessage(ErrorCode.SERVER_ERROR.getCode(), ex.getMessage());
    }
}
