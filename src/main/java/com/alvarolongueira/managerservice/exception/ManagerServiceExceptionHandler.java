package com.alvarolongueira.managerservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManagerServiceExceptionHandler {

	@ExceptionHandler(ManagerServiceException.class)
	public ResponseEntity<String> handleClientException(ManagerServiceException e) {
		return new ResponseEntity<String>(e.getMessage(), e.getStatus());
	}

}
