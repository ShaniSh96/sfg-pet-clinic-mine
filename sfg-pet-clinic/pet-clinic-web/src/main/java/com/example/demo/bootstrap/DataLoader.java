package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Owner;
import com.example.demo.model.PetType;
import com.example.demo.model.Vet;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetTypeService;
import com.example.demo.service.VetService;
import com.example.demo.service.map.OwnerMapService;
import com.example.demo.service.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	
	public DataLoader(OwnerService ownerService,VetService vetService,PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		PetType dog = new PetType();
		dog.setName("Jim");
		PetType saveDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Ruskel");
		PetType saveCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Bill");
		owner1.setLastName("Murray");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Mark");
		owner2.setLastName("Benith");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Bob");
		vet1.setLastName("Builder");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Tim");
		vet2.setLastName("parson");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		
	}

	
}
