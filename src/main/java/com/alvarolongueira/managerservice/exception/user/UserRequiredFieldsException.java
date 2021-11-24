package com.alvarolongueira.managerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.controller.request.user.CreateUserRequest;
import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class UserRequiredFieldsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public UserRequiredFieldsException(CreateUserRequest request) {
		super("Empty required fields: " + request, HttpStatus.BAD_REQUEST);
	}

}
