package com.alvarolongueira.customerservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alvarolongueira.customerservice.repository.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long>{

	Optional<UserEntity> findByNameAndPass(String name, String password);

}
