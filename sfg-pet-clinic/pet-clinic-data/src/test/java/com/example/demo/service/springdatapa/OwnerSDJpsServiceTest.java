package com.example.demo.service.springdatapa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Owner;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.PetRepository;
import com.example.demo.repositories.PetTypeRepository;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpsServiceTest {
	
	@Mock
	OwnerRepository ownerrepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpsService service;
	
	
	@BeforeEach
	void setUp() {
		
	}

	@Test
	void testFindAll() {
		
		Set<Owner> returnedSet = new HashSet<>();
		returnedSet.add(Owner.builder().id(1l).lastName("ABC").build());
		
		when(ownerrepository.findAll()).thenReturn(returnedSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		Assertions.assertEquals(1, owners.size());
	}

	@Test
	void testFindById() {
		

		Owner returnOwner = (Owner.builder().id(1l).lastName("ABC").build());
		
		when(ownerrepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1l);
		assertNotNull(owner);
	}

	@Test
	void testSave() {
		Owner returnOwner = (Owner.builder().id(1l).lastName("ABC").build());
		
		when(ownerrepository.save(any())).thenReturn(returnOwner);
		Owner saveOwner = service.save(returnOwner);
		assertNotNull(saveOwner);
	}

	@Test
	void testDelete() {
		Owner returnOwner = (Owner.builder().id(1l).lastName("ABC").build());
		
		service.delete(returnOwner);
		verify(ownerrepository,times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		Owner returnOwner = (Owner.builder().id(1l).lastName("ABC").build());
		
		service.deleteById(1l);
		verify(ownerrepository,times(1)).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {

		Owner returnOwner = (Owner.builder().id(1l).lastName("ABC").build());
		
		when(ownerrepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner ABC = service.findByLastName("ABC");
		
		Assertions.assertEquals("ABC", ownerrepository.findByLastName("ABC").getLastName());
	}

}
