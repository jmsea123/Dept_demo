package com.hyz.dept.common;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public R<Void> handle(RuntimeException e) {
        return R.fail(e.getMessage());
    }
}