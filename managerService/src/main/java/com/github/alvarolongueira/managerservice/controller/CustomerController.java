package com.github.alvarolongueira.managerservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.response.ResponseBody;
import com.github.alvarolongueira.managerservice.controller.response.customer.CustomerResponse;
import com.github.alvarolongueira.managerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> get() {
		return ResponseBody.of(customerService.getAllCustomers());
	}

	@GetMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable(name = "customerId") long customerId) {
		return ResponseBody.of(customerService.getCustomerById(customerId));
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
		return ResponseBody.of(customerService.createCustomer(request));
	}

	@DeleteMapping(path = "/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") long customerId) {
		return ResponseBody.of(customerService.deleteCustomer(customerId));
	}

	@PatchMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable(name = "customerId") long customerId, @RequestBody UpdateCustomerRequest request) {
		return ResponseBody.of(customerService.updateCustomer(customerId, request));
	}

}
