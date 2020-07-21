package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.data.model.Owner;
import com.example.data.model.Vet;
import com.example.data.service.OwnerService;
import com.example.data.service.VetService;
import com.example.data.service.map.OwnerMapService;
import com.example.data.service.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	public DataLoader() {
		ownerService = new OwnerMapService();
		vetService = new VetMapService();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Bill");
		owner1.setLastName("Murray");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Mark");
		owner2.setLastName("Benith");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Bob");
		vet1.setLastName("Builder");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Tim");
		vet2.setLastName("parson");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		
	}

	
}
