package com.example.demo.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Vet;
import com.example.demo.service.VetService;

@Controller
public class VetController {

	private final VetService vetService;
	
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}


	@RequestMapping({"/vets","/vets/index","/vets/index.html","/vets.html"})
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		return "vets/Index";
	}
	
	@GetMapping("/api/vets")
	//response boy is going to say I want the result to be formatted as JSON
	public @ResponseBody Set<Vet> getVetJSON() {
		return vetService.findAll();
	}
	
}
