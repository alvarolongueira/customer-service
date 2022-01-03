package com.alvarolongueira.customerservice.controller.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginRequest {

	private String user;

	private String pass;

}
