package com.example.data.service;

import java.util.Set;

import com.example.data.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

	Owner findByLastName(String lastName);
	
}
