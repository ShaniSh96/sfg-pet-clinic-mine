package com.example.demo.service.map;

import java.util.HashMap;

import com.example.demo.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

	protected Map<Long,T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if(object != null) {
			if(object.getId() == null) {
				object.setId(findNextId());
			}
			map.put(findNextId(), object);
		}else {
			System.out.println("Null object");
		}
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private long findNextId(){
		Long nextId = null;
		try {
			return Collections.max(map.keySet()) + 1;
		}catch(NoSuchElementException e) {
			nextId = 1L;
		}
	
		return nextId;
	}
	
}
