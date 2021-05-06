package com.orangeven.qiafan.app.common.advice.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orangeven.qiafan.app.common.model.http.ErrorResponse;

@RestControllerAdvice
public class RestServerErrorResponseAdvice extends ResponseEntityExceptionHandler{


	private ErrorResponse fillErrorResponse(Exception e) {
    	ErrorResponse response = new ErrorResponse(e.getMessage());
    	return response;
    }
}
