package com.example.demo.service.springdatapa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Visit;
import com.example.demo.repositories.VisitRepository;
import com.example.demo.service.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService{
	private final VisitRepository visitRepo;

	public VisitSDJpaService(VisitRepository visitRepo) {
		this.visitRepo = visitRepo;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepo.findAll().forEach(visit -> visits.add(visit));
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepo.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepo.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepo.deleteById(id);
	}
	
	

}
