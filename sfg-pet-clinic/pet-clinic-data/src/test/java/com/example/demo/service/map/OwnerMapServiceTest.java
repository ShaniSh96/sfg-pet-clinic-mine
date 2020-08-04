package com.example.demo.service.map;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.demo.model.Owner;
import com.example.demo.service.PetService;
import com.example.demo.service.PetTypeService;

class OwnerMapServiceTest {

	final Long ownerId = 1l;
	final String lastName = "ABC";
	@Mock
	PetService petService;
	
	@Mock
	PetTypeService petTypeService;
	
	OwnerMapService ownerMapService;
	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(petService, petTypeService);
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}
	 
	@Test
	void testSaveOwner() {
		
		// With giving id
		//Owner owner2 = ownerMapService.save(Owner.builder().id(2L).build());
		//Assertions.assertEquals(2, owner2.getId());
		
		
		// without giving id
		Owner owner2 = ownerMapService.save(Owner.builder().build());
		Assertions.assertNotNull(owner2);
		Assertions.assertNotNull(owner2.getId());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		Assertions.assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		Assertions.assertEquals(ownerId, owner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		Assertions.assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		Assertions.assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner lastNameOwner = ownerMapService.findByLastName(lastName);
		Assertions.assertEquals(lastName, lastNameOwner.getLastName());
	}

}
