package com.alvarolongueira.managerservice.security;

import lombok.Data;

@Data
public class UserApplication {

	public String userName;

	public String token;

	public String role;

}
