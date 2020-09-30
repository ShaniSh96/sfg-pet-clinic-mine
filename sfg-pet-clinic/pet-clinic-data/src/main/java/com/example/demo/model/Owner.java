package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"pets"})
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{
	
	
	@Builder
	public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String telephone, String city) {
		super(id,firstName,lastName);
		if(pets != null)
			this.pets = pets;
		this.address = address;
		this.telephone = telephone;
		this.city = city;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	
	@Column(name = "address")
	private String address;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "city")
	private String city;
	
	
	
	
}
