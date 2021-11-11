package com.github.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

	private final String MAIN_URL = "/login";

	@Autowired
	private LoginController controller;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testMainUrl() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> response = template.getForEntity(MAIN_URL, String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void successLogin() throws Exception {
		// TODO
	}

	@Test
	public void failLogin() throws Exception {
		// TODO
	}

}
