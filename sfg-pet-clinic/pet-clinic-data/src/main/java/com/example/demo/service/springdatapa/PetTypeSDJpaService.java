package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.PetType;
import com.example.demo.repositories.PetTypeRepository;
import com.example.demo.service.PetTypeService;

public class PetTypeSDJpaService implements PetTypeService{

	private final PetTypeRepository petTypeRepo;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepo) {
		this.petTypeRepo = petTypeRepo;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		
		petTypeRepo.findAll().forEach(petType -> petTypes.add(petType));
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepo.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepo.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepo.deleteById(id);
	}
	
	
}
