package com.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alvarolongueira.managerservice.controller.UserController;

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
		ResponseEntity<String> response = template.getForEntity(MAIN_URL, String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testMainUrlLoginSuccess() throws Exception {
		// TODO
	}

	@Test
	public void testMainUrlWithoutLogin() throws Exception {
		// TODO
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

	@Test
	public void anyModificationWithSuccessLogin() throws Exception {
		// TODO
	}

	@Test
	public void anyModificationWithoutLogin() throws Exception {
		// TODO
	}

}