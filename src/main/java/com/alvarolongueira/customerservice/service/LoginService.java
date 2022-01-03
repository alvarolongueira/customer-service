package com.alvarolongueira.customerservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.alvarolongueira.customerservice.exception.user.UserNotFoundException;
import com.alvarolongueira.customerservice.repository.UserRepository;
import com.alvarolongueira.customerservice.repository.entity.UserEntity;
import com.alvarolongueira.customerservice.security.RoleFactory;
import com.alvarolongueira.customerservice.security.UserApplication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	private static final String AUTHORITIES = "authorities";
	private static final String PREFIX = "Bearer ";

	private final UserRepository repository;

	public LoginService(UserRepository repository) {
		this.repository = repository;
	}

	public UserApplication login(String userName, String password) {
		
		Optional<UserEntity> userEntity = this.repository.findByNameAndPass(userName, password);
		if (!userEntity.isPresent()) {
			throw new UserNotFoundException("Wrong credentials");
		}

		UserEntity user = userEntity.get();
		String role = RoleFactory.getRole(user.getRole());
		String token = this.getJWTToken(userName, role);
		
		UserApplication userApplication = new UserApplication();
		userApplication.setUserName(userName);
		userApplication.setRole(role);
		userApplication.setToken(token);
		return userApplication;
	}

	private String getJWTToken(String username, String role) {
		final String secretKey = "secretKey";
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
