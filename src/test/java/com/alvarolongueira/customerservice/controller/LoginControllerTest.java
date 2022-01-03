package com.alvarolongueira.customerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alvarolongueira.customerservice.controller.request.user.UserLoginRequest;
import com.alvarolongueira.customerservice.mock.MockData;
import com.alvarolongueira.customerservice.security.UserApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

	private final String MAIN_URL = "/login";
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private TestRestTemplate template;

	@Test
	public void successLogin() throws Exception {
		UserLoginRequest request = new UserLoginRequest(MockData.USER_2.getName(), MockData.USER_2.getPass());
		ResponseEntity<String> responseEntity = this.template.postForEntity(this.MAIN_URL, request, String.class);
		
		UserApplication userApplication = this.objectMapper.readValue(responseEntity.getBody(), UserApplication.class);

		Assert.assertEquals(MockData.USER_2.getName(), userApplication.getUserName());
		Assert.assertEquals(MockData.USER_2.getRole(), userApplication.getRole());
	}

	@Test
	public void failLoginWrongUser() throws Exception {
		UserLoginRequest request = new UserLoginRequest("no_existent", "pass");
		ResponseEntity<String> responseEntity = this.template.postForEntity(this.MAIN_URL, request, String.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void failLoginWrongPass() throws Exception {
		UserLoginRequest request = new UserLoginRequest(MockData.USER_2.getName(), "invented_pass");
		ResponseEntity<String> responseEntity = this.template.postForEntity(this.MAIN_URL, request, String.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
