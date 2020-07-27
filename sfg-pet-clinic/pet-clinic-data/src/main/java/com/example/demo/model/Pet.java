package com.example.demo.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

	private String name;
	private PetType pettype;
	private Owner owner;
	private LocalDate birthday;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getPettype() {
		return pettype;
	}
	public void setPettype(PetType pettype) {
		this.pettype = pettype;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
}
