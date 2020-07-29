package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
