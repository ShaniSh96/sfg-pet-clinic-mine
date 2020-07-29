package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Speciality;
import com.example.demo.repositories.SpecialtyRepository;
import com.example.demo.service.SpecialtiesService;

@Service
@Profile("springdatajpa")
public class VetSpecialtySDJpaService implements SpecialtiesService{

	private final SpecialtyRepository specialtyRepo;

	public VetSpecialtySDJpaService(SpecialtyRepository specialtyRepo) {
		this.specialtyRepo = specialtyRepo;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialties = new HashSet<>();
		specialtyRepo.findAll().forEach(specialty -> specialties.add(specialty));
		return specialties;
	}

	@Override
	public Speciality findById(Long id) {
		return specialtyRepo.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialtyRepo.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepo.deleteById(id);
	}
	
	
}
