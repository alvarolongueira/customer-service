package com.alvarolongueira.customerservice.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.alvarolongueira.customerservice.repository.entity.CustomerEntity;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long> {

	Optional<CustomerEntity> findByNameAndSurname(String name, String surname);

}
