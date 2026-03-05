package com.hospitalmanagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ResponseStatus> handlerResource(ResourceNotFoundException re){
		
		ResponseStatus r=new ResponseStatus(re.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
		
		return new ResponseEntity<ResponseStatus>(r,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStatus> defaultExceptionHandler(Exception e){
		
		ResponseStatus re=new ResponseStatus(e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
		
		return new ResponseEntity<ResponseStatus>(re,HttpStatus.NOT_FOUND);
	}
}
