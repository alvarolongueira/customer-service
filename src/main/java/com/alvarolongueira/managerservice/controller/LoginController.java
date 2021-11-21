package com.alvarolongueira.managerservice.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvarolongueira.managerservice.security.Role;
import com.alvarolongueira.managerservice.security.UserApplication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static final String AUTHORITIES = "authorities";
	private static final String PREFIX = "Bearer ";

	@PostMapping
	public UserApplication login(@RequestParam("user") String userName, @RequestParam("pass") String pass) {
		
		// TODO database 
		// TODO check pass
		// TODO assign Role
		String role = Role.USER;
		
		String token = getJWTToken(userName, role);
		UserApplication user = new UserApplication();
		user.setUserName(userName);
		user.setRole(role);
		user.setToken(token);

		return user;
	}

	private String getJWTToken(String username, String role) {
		String secretKey = "secretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
		
		String token = Jwts
				.builder()
				.setSubject(username)
				.claim(AUTHORITIES,
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
				.compact();

		return PREFIX + token;
	}

}
