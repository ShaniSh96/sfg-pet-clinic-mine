package com.example.demo.service.map;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import com.example.demo.service.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

	private final PetService petService;
	private final PetTypeService petTypeService;
	
	
	
	public OwnerMapService(PetService petService, PetTypeService petTypeService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPettype() != null) {
						pet.setPettype(petTypeService.save(pet.getPettype()));
					}else {
						throw new RuntimeException("Pet Type Is Required.");
					}
					
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
								
					}
				});
			}
			return super.save(object);
		}else {
			return null;
		}
		
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

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll()
				.stream()
				.filter(owner -> owner.getLastName().equals(lastName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String name) {
		
		return this.findAll()
				.stream()
				.filter(owner -> owner.getLastName().contains(name))
				.collect(Collectors.toList());
	}
	

	
}
