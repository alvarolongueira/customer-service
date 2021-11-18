package com.alvarolongueira.managerservice.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.alvarolongueira.managerservice.repository.entity.CustomerEntity;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long> {

	Optional<CustomerEntity> findByNameAndSurname(String name, String surname);

}
