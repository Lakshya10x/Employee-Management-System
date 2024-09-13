package com.company.management.advice;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@ControllerAdvice
public class MyControllerAdviceUpdated extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    // Custom error response format
    public static class ErrorResponse {
        private final String message;
        private final int statusCode;

        public ErrorResponse(String message, int statusCode) {
            this.message = message;
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    // Handle custom EmptyInputException
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<ErrorResponse> handleEmptyInput(EmptyInputException ex) {
        logger.error("EmptyInputException occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Input field is empty. Please check your input.", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
        logger.error("NoSuchElementException occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("No value present in the database. Please modify your request.", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle HttpRequestMethodNotSupportedException
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logger.error("HttpRequestMethodNotSupportedException occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("The HTTP method is not supported for this request.", HttpStatus.METHOD_NOT_ALLOWED.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        logger.error("Exception occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
