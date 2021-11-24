package com.alvarolongueira.managerservice.controller;

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

import com.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.alvarolongueira.managerservice.controller.response.ResponseBody;
import com.alvarolongueira.managerservice.controller.response.customer.CustomerListResponse;
import com.alvarolongueira.managerservice.controller.response.customer.CustomerResponse;
import com.alvarolongueira.managerservice.domain.Customer;
import com.alvarolongueira.managerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<CustomerListResponse> get() {
		List<Customer> customers = customerService.getAllCustomers();
		List<String> names = customers.stream().map(value -> value.getName()).collect(Collectors.toList());
		CustomerListResponse response = new CustomerListResponse();
		response.setNames(names);
		return ResponseBody.of(response);
	}

	@GetMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable(name = "customerId") long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
		Customer customer = customerService.createCustomer(request);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

	@DeleteMapping(path = "/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") long customerId) {
		return ResponseBody.of(customerService.deleteCustomer(customerId));
	}

	@PutMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable(name = "customerId") long customerId, @RequestBody UpdateCustomerRequest request) {
		Customer customer = customerService.updateCustomer(customerId, request);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

}
