package com.example.data.service;

import java.util.Set;

import com.example.data.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);
	Owner findById(Long Id);
	Owner save(Owner owner);
	Set<Owner> findAll();
	
}
