package com.orangeven.qiafan.app.common.advice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orangeven.qiafan.app.common.controller.exception.AlreadyLogedInException;
import com.orangeven.qiafan.app.common.controller.exception.IllegalRequestParameterException;
import com.orangeven.qiafan.app.common.controller.exception.NotLoggedInException;
import com.orangeven.qiafan.app.common.model.http.ErrorResponse;
import com.orangeven.qiafan.app.common.service.exception.AuthenFailedException;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;
import com.orangeven.qiafan.app.customer.model.Customer;

@RestControllerAdvice
public class RestClientErrorResponseAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(ResourceNotFoundException e) {
        return new ResponseEntity<ErrorResponse>(fillErrorResponse(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> resourceAlreadyExistsExceptionHandler(ResourceExistsException e) {
        return new ResponseEntity<ErrorResponse>(fillErrorResponse(e), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> resourceSetTooLargeExceptionHandler(ResourceSetSizeTooLargeException e) {
        return new ResponseEntity<ErrorResponse>(fillErrorResponse(e), HttpStatus.PAYLOAD_TOO_LARGE);

    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> illegalResquestParameterExceptionHandler(IllegalRequestParameterException e) {
    	return new ResponseEntity<ErrorResponse>(fillErrorResponse(e), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler
    public ResponseEntity<Customer> alreadyLogedInExceptionHandler(AlreadyLogedInException e) {
    	return ResponseEntity.ok().build();
    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notLoggedInException(NotLoggedInException e) {
    	return new ResponseEntity<ErrorResponse>(HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> authenFailedException(AuthenFailedException e) {
    	return new ResponseEntity<ErrorResponse>(HttpStatus.UNAUTHORIZED);
    }
    
    private ErrorResponse fillErrorResponse(Exception e) {
    	ErrorResponse response = new ErrorResponse(e.getMessage());
    	return response;
    }

}
