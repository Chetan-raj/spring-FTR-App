package com.infy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoSuchTerminalException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchTerminalException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	

	
	

}
