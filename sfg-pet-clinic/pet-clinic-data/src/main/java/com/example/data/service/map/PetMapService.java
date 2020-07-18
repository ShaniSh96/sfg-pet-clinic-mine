package com.example.data.service.map;

import java.util.Set;

import com.example.data.model.Owner;
import com.example.data.model.Pet;
import com.example.data.service.CrudService;

public class PetMapService extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long>{

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}


	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}
	
}
