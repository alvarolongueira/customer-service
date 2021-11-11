package com.github.alvarolongueira.managerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.response.customer.CustomerListResponse;
import com.github.alvarolongueira.managerservice.controller.response.customer.CustomerResponse;
import com.github.alvarolongueira.managerservice.domain.Customer;
import com.github.alvarolongueira.managerservice.repository.CustomerRepository;
import com.github.alvarolongueira.managerservice.repository.entity.CustomerEntity;

@Service
public class CustomerService {

	private CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public CustomerListResponse getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		this.repository.findAll().forEach(value -> customers.add(Customer.convertToDomain(value)));

		List<String> names = customers.stream().map(value -> value.getName()).collect(Collectors.toList());

		CustomerListResponse response = new CustomerListResponse();
		response.setNames(names);
		return response;
	}

	public CustomerResponse getCustomerById(long customerId) {
		Optional<CustomerEntity> entity = this.repository.findById(customerId);
		if (!entity.isPresent()) {
			//TODO generar excepcion
		}
		
		Customer customer = Customer.convertToDomain(entity.get());
		CustomerResponse response = new CustomerResponse(customer.getName(), customer.getSurname(), customer.getPhoto());
		return response;
	}

	public CustomerResponse createCustomer(CreateCustomerRequest request) {
		// TODO
		return null;
	}

	public Void deleteCustomer(long customerId) {
		// TODO
		return null;
	}

	public CustomerResponse updateCustomer(long customerId, UpdateCustomerRequest request) {
		// TODO
		return null;
	}

}
