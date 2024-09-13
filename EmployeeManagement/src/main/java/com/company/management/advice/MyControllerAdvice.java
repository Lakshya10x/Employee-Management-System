package com.company.management.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.company.management.custom.exception.EmptyInputException;

//@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{

	//If controller is not able to handle this exception, it will not terminate the code
	//But rather handle by showing proper error message to the end user
	/** 
	 Please intercept any exception handling in any controller across this project 
	 (When these controllers are not able to handle the exceptions with try catch)
	 */
	// when custom exception handler was called
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
	{
		return new ResponseEntity<String>("Input field is empty,Please look into it", HttpStatus.BAD_REQUEST);
	}
	
	// when existing default handler was called
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException)
	{
		return new ResponseEntity<String>("No value present in DB, please change your request",HttpStatus.NOT_FOUND);
	}
	
	/**
	  ResponseEntityExceptionHandler class have multiple methods 
	  Ex : handleHandlerMethodValidationException, handleConversionNotSupported
	  		handleMethodArgumentNotValid, etc
	  By overriding these and put your own implementation,
	  you'll be capable enough to handle/ intercept any exception 
	  that are written into as a method in this class & you dont have to think about broken code
	  	  		
	 */
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Please change http method type", HttpStatus.NOT_FOUND);
	}
	
}
