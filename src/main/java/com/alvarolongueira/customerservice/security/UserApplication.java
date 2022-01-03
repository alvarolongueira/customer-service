package com.alvarolongueira.customerservice.security;

import lombok.Data;

@Data
public class UserApplication {

	public String userName;

	public String token;

	public String role;

}
