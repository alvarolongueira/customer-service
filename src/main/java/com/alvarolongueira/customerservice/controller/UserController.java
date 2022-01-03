package com.alvarolongueira.customerservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvarolongueira.customerservice.controller.request.user.CreateUserRequest;
import com.alvarolongueira.customerservice.controller.request.user.UpdateUserRequest;
import com.alvarolongueira.customerservice.controller.response.ResponseBody;
import com.alvarolongueira.customerservice.controller.response.user.UserListResponse;
import com.alvarolongueira.customerservice.controller.response.user.UserResponse;
import com.alvarolongueira.customerservice.domain.User;
import com.alvarolongueira.customerservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<UserListResponse> get() {
		List<User> users = this.userService.getAllUsers();
		List<String> names = users.stream().map(value -> value.getName()).collect(Collectors.toList());
		UserListResponse response = new UserListResponse();
		response.setNames(names);
		return ResponseBody.of(response);
	}

	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable(name = "userId") long userId) {
		User user = this.userService.getUserById(userId);
		UserResponse response = UserResponse.convertToResponse(user);
		return ResponseBody.of(response);
	}

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
		User user = this.userService.createUser(request);
		UserResponse response = UserResponse.convertToResponse(user);
		return ResponseBody.of(response);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId") long userId) {
		return ResponseBody.of(this.userService.deleteUser(userId));
	}

	@PutMapping(path = "/{userId}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable(name = "userId") long userId, @RequestBody UpdateUserRequest request) {
		User user = this.userService.updateUser(userId, request);
		UserResponse response = UserResponse.convertToResponse(user);
		return ResponseBody.of(response);
	}

}
