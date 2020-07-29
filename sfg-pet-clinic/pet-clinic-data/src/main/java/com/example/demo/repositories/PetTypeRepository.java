package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
