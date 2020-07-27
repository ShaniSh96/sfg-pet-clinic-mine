package com.example.demo.service.map;

import java.util.Set;

import com.example.demo.model.Speciality;
import com.example.demo.service.SpecialtiesService;

public class SpecialtiesMapService extends AbstractMapService<Speciality, Long> implements SpecialtiesService{

	public  Speciality save(Speciality speciality) {
		// TODO Auto-generated method stub
		return super.save(speciality);
	}
	
	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}
	
	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Speciality speciality) {
		super.delete(speciality);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
