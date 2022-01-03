package com.alvarolongueira.customerservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvarolongueira.customerservice.controller.request.user.UserLoginRequest;
import com.alvarolongueira.customerservice.security.UserApplication;
import com.alvarolongueira.customerservice.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	public UserApplication login(@RequestBody UserLoginRequest request) {
		return this.loginService.login(request.getUser(), request.getPass());
	}

}
