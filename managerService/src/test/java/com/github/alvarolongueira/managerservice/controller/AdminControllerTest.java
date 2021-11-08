package com.github.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

	@Autowired
	private AdminController controller;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testMainUrl() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> response = template.getForEntity("/admin", String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testMainUrlLoginSuccess() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> response = template.getForEntity("/admin", String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testMainUrlWithoutLogin() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> response = template.getForEntity("/admin", String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
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
	public void listUsers() throws Exception {
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
