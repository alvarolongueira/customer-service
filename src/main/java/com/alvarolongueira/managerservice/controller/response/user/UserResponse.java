package com.alvarolongueira.managerservice.controller.response.user;

import com.alvarolongueira.managerservice.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private String name;

	private String pass;

	private String role;

	public static UserResponse convertToResponse(User user) {
		return new UserResponse(user.getName(), user.getPass(), user.getRole());
	}
}
