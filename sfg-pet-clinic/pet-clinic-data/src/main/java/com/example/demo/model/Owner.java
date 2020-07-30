package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = {"pets"})
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	
	@Column(name = "address")
	private String address;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "city")
	private String city;
}
