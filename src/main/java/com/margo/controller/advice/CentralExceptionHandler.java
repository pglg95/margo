package com.margo.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler{

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public Integer defaultErrorHandler() {
        return -1;
    }

}
