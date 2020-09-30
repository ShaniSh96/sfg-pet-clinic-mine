package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String name);
}
