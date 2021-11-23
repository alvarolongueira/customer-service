package com.alvarolongueira.managerservice.controller.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {

	private String name;

	private String pass;

	private String role;

}
