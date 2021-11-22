package com.alvarolongueira.managerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class UserNotFoundException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

}
