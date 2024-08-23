package com.student.global_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import com.student.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex){
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ex.getClass().getSimpleName()
				);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	public static class ErrorDetails{
		private int statusCode;
		private String message;
		private String exceptionType;
		public ErrorDetails() {
			super();
		}
		public ErrorDetails(int statusCode, String message, String exceptionType) {
			super();
			this.statusCode = statusCode;
			this.message = message;
			this.exceptionType = exceptionType;
		}
		public int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getExceptionType() {
			return exceptionType;
		}
		public void setExceptionType(String exceptionType) {
			this.exceptionType = exceptionType;
		}

	}

}
