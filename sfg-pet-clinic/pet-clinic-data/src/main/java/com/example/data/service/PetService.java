package com.example.data.service;

import java.util.Set;

import com.example.data.model.Pet;

public interface PetService {

	Pet findById(Long Id);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
