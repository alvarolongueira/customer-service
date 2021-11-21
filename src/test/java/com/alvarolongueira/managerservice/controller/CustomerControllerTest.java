package com.alvarolongueira.managerservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.alvarolongueira.managerservice.controller.response.customer.CustomerListResponse;
import com.alvarolongueira.managerservice.controller.response.customer.CustomerResponse;
import com.alvarolongueira.managerservice.mock.MockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	private final String MAIN_URL = "/customer/";
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private CustomerController controller;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testMainUrl() throws Exception {
		Assert.assertNotNull(controller);
		ResponseEntity<String> responseEntity = template.getForEntity(MAIN_URL, String.class);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllCustomers() throws Exception {
		ResponseEntity<String> responseEntity = template.getForEntity(MAIN_URL, String.class);

		CustomerListResponse customerList = objectMapper.readValue(responseEntity.getBody(), CustomerListResponse.class);

		Assert.assertEquals(ImmutableList.of(MockData.CUSTOMER_1.getName(), MockData.CUSTOMER_2.getName()), customerList.getNames());
	}

	@Test
	public void getFullCustomerInformation() throws Exception {
		ResponseEntity<String> responseEntity = template.getForEntity(MAIN_URL + MockData.CUSTOMER_1.getId(), String.class);

		CustomerResponse customer = objectMapper.readValue(responseEntity.getBody(), CustomerResponse.class);

		Assert.assertEquals(MockData.CUSTOMER_1.getName(), customer.getName());
		Assert.assertEquals(MockData.CUSTOMER_1.getSurname(), customer.getSurname());
		Assert.assertEquals(MockData.CUSTOMER_1.getPhoto(), customer.getPhoto());
	}

	@Test
	@DirtiesContext
	public void createCustomerSuccess() throws Exception {
		CreateCustomerRequest request = new CreateCustomerRequest(MockData.CUSTOMER_3.getName(), MockData.CUSTOMER_3.getSurname(),
				MockData.CUSTOMER_3.getPhoto());
		ResponseEntity<String> responseEntity = template.postForEntity(MAIN_URL, request, String.class);

		CustomerResponse customer = objectMapper.readValue(responseEntity.getBody(), CustomerResponse.class);

		Assert.assertEquals(MockData.CUSTOMER_3.getName(), customer.getName());
		Assert.assertEquals(MockData.CUSTOMER_3.getSurname(), customer.getSurname());
		Assert.assertEquals(MockData.CUSTOMER_3.getPhoto(), customer.getPhoto());
		// TODO validar creador
		// TODO validar modificador
	}

	@Test
	public void createCustomerFailEmptyFields() throws Exception {
		CreateCustomerRequest request = new CreateCustomerRequest(MockData.CUSTOMER_3.getName(), "", 0L);

		ResponseEntity<String> responseEntity = template.postForEntity(MAIN_URL, request, String.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void createCustomerFailDuplicateFields() throws Exception {
		CreateCustomerRequest request = new CreateCustomerRequest(MockData.CUSTOMER_1.getName(), MockData.CUSTOMER_1.getSurname(),
				MockData.CUSTOMER_1.getPhoto());

		ResponseEntity<String> responseEntity = template.postForEntity(MAIN_URL, request, String.class);

		Assert.assertEquals(HttpStatus.NOT_MODIFIED, responseEntity.getStatusCode());
	}

	@Test
	@DirtiesContext
	public void updateCustomer() throws Exception {
		UpdateCustomerRequest request = new UpdateCustomerRequest(MockData.CUSTOMER_1.getName(), "otroSurname", MockData.CUSTOMER_1.getPhoto());
		HttpEntity<UpdateCustomerRequest> httpEntity = new HttpEntity<UpdateCustomerRequest>(request);

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + MockData.CUSTOMER_1.getId(), HttpMethod.PUT, httpEntity, String.class);
		CustomerResponse customer = objectMapper.readValue(responseEntity.getBody(), CustomerResponse.class);

		Assert.assertEquals(MockData.CUSTOMER_1.getName(), customer.getName());
		Assert.assertEquals("otroSurname", customer.getSurname());
		Assert.assertEquals(MockData.CUSTOMER_1.getPhoto(), customer.getPhoto());
		// TODO validar creador
		// TODO validar modificador
	}

	@Test
	public void updateCustomerFailNotExists() throws Exception {
		UpdateCustomerRequest request = new UpdateCustomerRequest(MockData.CUSTOMER_1.getName(), "otroSurname", MockData.CUSTOMER_1.getPhoto());
		HttpEntity<UpdateCustomerRequest> httpEntity = new HttpEntity<UpdateCustomerRequest>(request);

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + 33, HttpMethod.PUT, httpEntity, String.class);

		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void updateCustomerFailDuplicateFields() throws Exception {
		UpdateCustomerRequest request = new UpdateCustomerRequest(MockData.CUSTOMER_2.getName(), MockData.CUSTOMER_2.getSurname(),
				MockData.CUSTOMER_1.getPhoto());
		HttpEntity<UpdateCustomerRequest> httpEntity = new HttpEntity<UpdateCustomerRequest>(request);

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + MockData.CUSTOMER_1.getId(), HttpMethod.PUT, httpEntity, String.class);

		Assert.assertEquals(HttpStatus.NOT_MODIFIED, responseEntity.getStatusCode());
	}

	@Test
	@DirtiesContext
	public void deleteCustomer() throws Exception {
		ResponseEntity<String> responseBeforeDelete = template.getForEntity(MAIN_URL + MockData.CUSTOMER_1.getId(), String.class);
		CustomerResponse customer = objectMapper.readValue(responseBeforeDelete.getBody(), CustomerResponse.class);
		Assert.assertEquals(MockData.CUSTOMER_1.getName(), customer.getName());
		Assert.assertEquals(HttpStatus.OK, responseBeforeDelete.getStatusCode());

		template.delete(MAIN_URL + MockData.CUSTOMER_1.getId());

		ResponseEntity<String> responseAfterDelete = template.getForEntity(MAIN_URL + MockData.CUSTOMER_1.getId(), String.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseAfterDelete.getStatusCode());
	}

	@Test
	public void deleteCustomerFailNotExists() throws Exception {
		HttpEntity<String> httpEntity = new HttpEntity<String>("");

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + 33, HttpMethod.DELETE, httpEntity, String.class);

		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

}
