package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vet;
import com.example.demo.repositories.VetRepository;
import com.example.demo.service.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpsService implements VetService{

	private final VetRepository vetRepo;
	
	public VetSDJpsService(VetRepository vetRepo) {
		this.vetRepo = vetRepo;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		
		vetRepo.findAll().forEach(vet -> vets.add(vet));
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepo.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepo.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepo.deleteById(id);
	}

	
}
