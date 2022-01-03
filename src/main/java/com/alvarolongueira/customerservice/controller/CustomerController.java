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

import com.alvarolongueira.customerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.customerservice.controller.request.customer.UpdateCustomerRequest;
import com.alvarolongueira.customerservice.controller.response.ResponseBody;
import com.alvarolongueira.customerservice.controller.response.customer.CustomerListResponse;
import com.alvarolongueira.customerservice.controller.response.customer.CustomerResponse;
import com.alvarolongueira.customerservice.domain.Customer;
import com.alvarolongueira.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<CustomerListResponse> get() {
		List<Customer> customers = this.customerService.getAllCustomers();
		List<String> names = customers.stream().map(value -> value.getName()).collect(Collectors.toList());
		CustomerListResponse response = new CustomerListResponse();
		response.setNames(names);
		return ResponseBody.of(response);
	}

	@GetMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable(name = "customerId") long customerId) {
		Customer customer = this.customerService.getCustomerById(customerId);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
		Customer customer = this.customerService.createCustomer(request);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

	@DeleteMapping(path = "/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") long customerId) {
		return ResponseBody.of(this.customerService.deleteCustomer(customerId));
	}

	@PutMapping(path = "/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable(name = "customerId") long customerId, @RequestBody UpdateCustomerRequest request) {
		Customer customer = this.customerService.updateCustomer(customerId, request);
		CustomerResponse response = CustomerResponse.convertToResponse(customer);
		return ResponseBody.of(response);
	}

}
