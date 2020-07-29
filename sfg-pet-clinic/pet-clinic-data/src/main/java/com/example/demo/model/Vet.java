package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToOne;

public class Vet extends Person{

	@ManyToOne
	private Set<Speciality>  specialties = new HashSet<>();

	public Set<Speciality> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Speciality> specialties) {
		this.specialties = specialties;
	}
	
	
}
