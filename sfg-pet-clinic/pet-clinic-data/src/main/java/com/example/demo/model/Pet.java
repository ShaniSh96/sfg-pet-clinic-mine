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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"visits"})
@NoArgsConstructor
@Entity
@Table(name = "pets")
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
	private Set<Visit> visits = new HashSet<>();

	public Pet(String name, PetType pettype, Owner owner, LocalDate birthday, Set<Visit> visits) {
		this.name = name;
		this.pettype = pettype;
		this.owner = owner;
		this.birthday = birthday;
		if(visits != null || visits.size() > 0)
			this.visits = visits;
	}
	
	
	
}
