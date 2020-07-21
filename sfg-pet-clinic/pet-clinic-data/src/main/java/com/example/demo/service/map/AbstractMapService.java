package com.example.demo.service.map;

import java.util.HashMap;
import java.util.*;

public abstract class AbstractMapService<T,ID> {

	protected Map<ID,T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(ID id,T object) {
		return map.put(id, object);
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
}
