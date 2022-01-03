package com.alvarolongueira.customerservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerServiceExceptionHandler {

	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<String> handleClientException(CustomerServiceException e) {
		return new ResponseEntity<String>(e.getMessage(), e.getStatus());
	}

}
