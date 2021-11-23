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

import com.alvarolongueira.managerservice.controller.request.user.CreateUserRequest;
import com.alvarolongueira.managerservice.controller.request.user.UpdateUserRequest;
import com.alvarolongueira.managerservice.controller.response.user.UserListResponse;
import com.alvarolongueira.managerservice.controller.response.user.UserResponse;
import com.alvarolongueira.managerservice.mock.MockData;
import com.alvarolongueira.managerservice.security.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	private final String MAIN_URL = "/user/";
	private final ObjectMapper objectMapper = new ObjectMapper();

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
		ResponseEntity<String> responseEntity = template.getForEntity(MAIN_URL, String.class);

		UserListResponse userList = objectMapper.readValue(responseEntity.getBody(), UserListResponse.class);

		Assert.assertEquals(ImmutableList.of(MockData.ADMIN_M.getName(), MockData.ADMIN_1.getName(), MockData.USER_2.getName(), MockData.USER_3.getName()),
				userList.getNames());
	}

	@Test
	@DirtiesContext
	public void createUser() throws Exception {
		CreateUserRequest request = new CreateUserRequest(MockData.USER_TEST.getName(), MockData.USER_TEST.getPass(), MockData.USER_TEST.getRole());
		ResponseEntity<String> responseEntity = template.postForEntity(MAIN_URL, request, String.class);

		UserResponse user = objectMapper.readValue(responseEntity.getBody(), UserResponse.class);

		Assert.assertEquals(MockData.USER_TEST.getName(), user.getName());
		Assert.assertEquals(MockData.USER_TEST.getPass(), user.getPass());
		Assert.assertEquals(MockData.USER_TEST.getRole(), user.getRole());
	}

	@Test
	@DirtiesContext
	public void updateUser() throws Exception {
		ResponseEntity<String> responseBeforeUpdate = template.getForEntity(MAIN_URL + MockData.USER_2.getId(), String.class);
		UserResponse userBeforeUpdate = objectMapper.readValue(responseBeforeUpdate.getBody(), UserResponse.class);
		Assert.assertEquals(MockData.USER_2.getName(), userBeforeUpdate.getName());
		Assert.assertEquals(MockData.USER_2.getPass(), userBeforeUpdate.getPass());
		Assert.assertEquals(MockData.USER_2.getRole(), userBeforeUpdate.getRole());
		
		UpdateUserRequest request = new UpdateUserRequest("otroname", MockData.USER_2.getPass(), MockData.USER_2.getRole());
		HttpEntity<UpdateUserRequest> httpEntity = new HttpEntity<UpdateUserRequest>(request);

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + MockData.USER_2.getId(), HttpMethod.PUT, httpEntity, String.class);
		UserResponse user = objectMapper.readValue(responseEntity.getBody(), UserResponse.class);

		Assert.assertEquals("otroname", user.getName());
		Assert.assertEquals(MockData.USER_2.getPass(), user.getPass());
		Assert.assertEquals(MockData.USER_2.getRole(), user.getRole());
	}

	@Test
	@DirtiesContext
	public void changeAdminStatus() throws Exception {
		ResponseEntity<String> responseBeforeUpdate = template.getForEntity(MAIN_URL + MockData.USER_2.getId(), String.class);
		UserResponse userBeforeUpdate = objectMapper.readValue(responseBeforeUpdate.getBody(), UserResponse.class);
		Assert.assertEquals(Role.USER, userBeforeUpdate.getRole());

		UpdateUserRequest request = new UpdateUserRequest("otroname", MockData.USER_2.getPass(), Role.ADMIN);
		HttpEntity<UpdateUserRequest> httpEntity = new HttpEntity<UpdateUserRequest>(request);

		ResponseEntity<String> responseEntity = template.exchange(MAIN_URL + MockData.USER_2.getId(), HttpMethod.PUT, httpEntity, String.class);
		UserResponse user = objectMapper.readValue(responseEntity.getBody(), UserResponse.class);

		Assert.assertEquals("otroname", user.getName());
		Assert.assertEquals(Role.ADMIN, user.getRole());
	}

	@Test
	@DirtiesContext
	public void deleteUser() throws Exception {
		ResponseEntity<String> responseBeforeDelete = template.getForEntity(MAIN_URL + MockData.USER_2.getId(), String.class);
		UserResponse customer = objectMapper.readValue(responseBeforeDelete.getBody(), UserResponse.class);
		Assert.assertEquals(MockData.USER_2.getName(), customer.getName());
		Assert.assertEquals(HttpStatus.OK, responseBeforeDelete.getStatusCode());

		template.delete(MAIN_URL + MockData.USER_2.getId());

		ResponseEntity<String> responseAfterDelete = template.getForEntity(MAIN_URL + MockData.USER_2.getId(), String.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseAfterDelete.getStatusCode());
	}

}
