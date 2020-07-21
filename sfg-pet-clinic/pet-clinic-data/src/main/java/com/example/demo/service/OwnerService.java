package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

	Owner findByLastName(String lastName);
	
}
