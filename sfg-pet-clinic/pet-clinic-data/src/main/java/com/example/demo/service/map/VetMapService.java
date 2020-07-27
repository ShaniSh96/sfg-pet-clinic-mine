package com.example.demo.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.Speciality;
import com.example.demo.model.Vet;
import com.example.demo.service.SpecialtiesService;
import com.example.demo.service.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialtiesService specialtyService;
	
	public VetMapService(SpecialtiesService specialtyService) {
		this.specialtyService = specialtyService;
	}
@Override
	public Vet save(Vet object) {
		if(object.getSpecialties().size() > 0) {
			object.getSpecialties().forEach(specialty ->{
				if(specialty.getId() == null) {
					Speciality savedSpecialty = specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
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
