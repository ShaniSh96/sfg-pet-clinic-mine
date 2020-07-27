package com.example.demo.model;

import java.util.Set;

public class Vet extends Person{

	private Set<Speciality>  specialties;

	public Set<Speciality> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Speciality> specialties) {
		this.specialties = specialties;
	}
	
	
}
