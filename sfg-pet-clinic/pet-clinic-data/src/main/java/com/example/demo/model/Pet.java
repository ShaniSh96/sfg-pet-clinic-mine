package com.example.demo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pet extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType pettype;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(name = "birth_date")
	private LocalDate birthday;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
	private Set<Visit> visit = new HashSet<>();
	
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
	public Set<Visit> getVisit() {
		return visit;
	}
	public void setVisit(Set<Visit> visit) {
		this.visit = visit;
	}
	
	
}
