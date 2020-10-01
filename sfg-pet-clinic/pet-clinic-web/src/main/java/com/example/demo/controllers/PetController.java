package com.example.demo.controllers;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.PetType;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import com.example.demo.service.PetTypeService;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {
	
	private final PetTypeService petTypeService;
	private final OwnerService ownerService;
	private final PetService petService;
	
	public PetController(PetTypeService petTypeService, OwnerService ownerService, PetService petService) {
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
		this.petService = petService;
	}

	@ModelAttribute("types")
	public List<PetType> populatePetType(){
		return petTypeService.findAll().stream().collect(Collectors.toList());
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable Long ownerId, Model model) {
		return ownerService.findById(ownerId);
	}
	
	@InitBinder
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				
				setValue(LocalDate.parse(text));
			}
			
		});
	}
	
	@GetMapping("/pets/new")
	public String initCreationForm(Owner owner, Model model) {
		Pet pet = new Pet();
		owner.getPets().add(pet);
		pet.setOwner(owner);
		model.addAttribute("pet", pet);
		return "pets/createOrUpdatePetForm";
	}
	
	@PostMapping("/pets/new")
	public String processCreationForm(@Validated Owner owner, Pet pet, BindingResult result, Model model) {
		if(StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPets().contains(pet.getName())) {
			result.rejectValue("name", "duplicate", "name alreayd exists");
		} 

		owner.getPets().add(pet);
		if(result.hasErrors()) {
			model.addAttribute("pet", pet);
			return "pets/createOrUpdatePetForm";
		}else {
			petService.save(pet);
			return "redirect:/owners/"+owner.getId();
		}
	}
	
	@GetMapping("/pets/{petId}/edit")
	public String initUpdationForm(Model model, @PathVariable Long petId) {
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		return "pets/createOrUpdatePetForm";
	}
	
	@PostMapping("/pets/{petId}/edit")
	public String processUpdationForm(@Validated Pet pet, BindingResult result, Owner owner, Model model) {
		if(result.hasErrors()) {
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return "pets/createOrUpdatePetForm";
		}else {
			owner.getPets().add(pet);
			petService.save(pet);
			model.addAttribute("pet", pet);
			return "redirect:/owners/"+owner.getId();
		}
	}
}
