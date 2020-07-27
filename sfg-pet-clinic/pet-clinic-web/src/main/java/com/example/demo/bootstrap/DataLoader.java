package com.example.demo.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
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
		
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Bill");
		owner1.setLastName("Murray");
		owner1.setAddress("asd sdfghj");
		owner1.setCity("AHM");
		owner1.setTelephone("12345");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Mark");
		owner2.setLastName("Benith");
		owner2.setAddress("sdf dghjk");
		owner2.setCity("BVN");
		owner2.setTelephone("963852");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		
		PetType dog = new PetType();
		dog.setName("Jim");
		PetType saveDogPetType = petTypeService.save(dog);
		
		
		PetType cat = new PetType();
		cat.setName("Ruskel");
		PetType saveCatPetType = petTypeService.save(cat);
		
		
		Pet pet1 = new Pet();
		pet1.setPettype(saveDogPetType);
		pet1.setOwner(owner1);
		pet1.setBirthday(LocalDate.now());
		pet1.setName("Mikey");
		owner1.getPets().add(pet1);
		
		Pet pet2 = new Pet();
		pet2.setPettype(saveCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthday(LocalDate.now());
		pet2.setName("Fionna");
		owner2.getPets().add(pet2);
		
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
