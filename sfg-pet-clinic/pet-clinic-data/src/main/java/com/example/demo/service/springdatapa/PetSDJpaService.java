package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pet;
import com.example.demo.repositories.PetRepository;
import com.example.demo.service.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService{

	private final PetRepository petRepo;
	
	public PetSDJpaService(PetRepository petRepo) {
		this.petRepo = petRepo;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepo.findAll().forEach(pet -> pets.add(pet));
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepo.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return petRepo.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepo.deleteById(id);
	}

	
}
