package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Owner;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.PetRepository;
import com.example.demo.repositories.PetTypeRepository;
import com.example.demo.service.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpsService implements OwnerService{

	private final OwnerRepository ownerRepo;
	private final PetRepository petRepo;
	private final PetTypeRepository petTypeRepo;
	
	
	
	public OwnerSDJpsService(OwnerRepository ownerRepo, PetRepository petRepo, PetTypeRepository petTypeRepo) {
		this.ownerRepo = ownerRepo;
		this.petRepo = petRepo;
		this.petTypeRepo = petTypeRepo;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		
		ownerRepo.findAll().forEach(owner -> owners.add(owner));
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepo.findById(id).orElse(null); 
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepo.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepo.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		
		return ownerRepo.findByLastName(lastName);
	}

}
