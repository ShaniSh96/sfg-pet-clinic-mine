package com.example.data.service;

import java.util.Set;

import com.example.data.model.Vet;

public interface VetService {

	Vet findById(Long Id);
	Vet save(Vet vet);
	Set<Vet> findAll();
}
