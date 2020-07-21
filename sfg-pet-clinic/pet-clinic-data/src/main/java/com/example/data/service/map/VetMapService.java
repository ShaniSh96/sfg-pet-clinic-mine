package com.example.data.service.map;

import java.util.Set;

import com.example.data.model.Vet;
import com.example.data.service.VetService;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}
	
	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	

}
