package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name = "types")
public class PetType extends BaseEntity{
	
	@Column(name = "name")
	private String name;

	
	@Override
	public String toString() {
		return name;
	}

	@Builder
	public PetType(long id,String name) {
		super(id);
		this.name = name;
	}

	
	
}
