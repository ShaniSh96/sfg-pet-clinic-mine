package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{
	
	@Column(name = "description")
	private String description;

	
}
