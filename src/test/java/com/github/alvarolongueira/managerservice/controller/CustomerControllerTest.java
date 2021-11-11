package com.github.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	private final String MAIN_URL = "/customer";

	@Autowired
	private CustomerController controller;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testMainUrl() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> response = template.getForEntity(MAIN_URL, String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testMainUrlWithSuccessLogin() throws Exception {
		// TODO
	}

	@Test
	public void testMainUrlWithoutLogin() throws Exception {
		// TODO
	}

	@Test
	public void getAllCustomers() throws Exception {
		// TODO
	}

	@Test
	public void getFullCustomerInformation() throws Exception {
		// TODO
	}

	@Test
	public void createCustomerSuccess() throws Exception {
		// TODO
	}

	@Test
	public void createCustomerFailEmptyFields() throws Exception {
		// TODO
	}

	@Test
	public void updateCustomer() throws Exception {
		// TODO
	}

	@Test
	public void deleteCustomer() throws Exception {
		// TODO
	}

}
