package com.alvarolongueira.managerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class UserRequiredFieldsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public UserRequiredFieldsException(String message) {
		super(message, HttpStatus.BAD_REQUEST);
	}

}
