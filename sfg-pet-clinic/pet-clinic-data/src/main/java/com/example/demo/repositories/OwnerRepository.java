package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	Owner findByLastName(String lastName);
}
