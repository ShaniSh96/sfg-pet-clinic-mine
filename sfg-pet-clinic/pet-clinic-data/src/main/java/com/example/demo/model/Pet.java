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
import lombok.NoArgsConstructor;

@Data
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
	
	
	
}
