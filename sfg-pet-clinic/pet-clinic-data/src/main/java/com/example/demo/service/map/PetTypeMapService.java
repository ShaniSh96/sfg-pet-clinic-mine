package com.example.demo.service.map;

import java.util.Set;

import com.example.demo.model.PetType;
import com.example.demo.service.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public PetType save(PetType petType) {
		// TODO Auto-generated method stub
		return super.save(petType);
	}
	
	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}
	
	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(PetType petType) {
		super.delete(petType);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
