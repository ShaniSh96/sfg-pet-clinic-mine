package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Owner;
import com.example.demo.model.PetType;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetTypeService;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {
	
	private final PetTypeService petTypeService;
	private final OwnerService ownerService;
	
	public PetController(PetTypeService petTypeService, OwnerService ownerService) {
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
	}

	@ModelAttribute("types")
	public List<PetType> populatePetType(){
		return petTypeService.findAll().stream().collect(Collectors.toList());
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable Long OwnerId, Model model) {
		return ownerService.findById(OwnerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
