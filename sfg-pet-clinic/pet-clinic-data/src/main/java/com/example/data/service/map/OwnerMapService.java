package com.example.data.service.map;

import java.util.Set;

import com.example.data.model.Owner;
import com.example.data.service.CrudService;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(),object);
	}
	
	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	

	
}
