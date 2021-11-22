package com.alvarolongueira.managerservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alvarolongueira.managerservice.repository.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long>{

	Optional<UserEntity> findByNameAndPass(String name, String pass);

}
