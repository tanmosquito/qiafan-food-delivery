package com.orangeven.qiafan.app.common.advice.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestSuccessfulResponseAdvice extends ResponseEntityExceptionHandler {
}
