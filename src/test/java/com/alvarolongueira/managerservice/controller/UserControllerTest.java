package com.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	private final String MAIN_URL = "/user";

	@Autowired
	private UserController controller;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testMainUrl() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> responseEntity = template.getForEntity(MAIN_URL, String.class);
		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getAllUsers() throws Exception {
		// TODO
	}

	@Test
	public void createUser() throws Exception {
		// TODO
	}

	@Test
	public void updateUser() throws Exception {
		// TODO
	}

	@Test
	public void deleteUser() throws Exception {
		// TODO
	}

	@Test
	public void changeAdminStatus() throws Exception {
		// TODO
	}

}
