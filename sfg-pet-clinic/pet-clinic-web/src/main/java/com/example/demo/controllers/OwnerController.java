package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Owner;
import com.example.demo.service.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@RequestMapping({"/index","/index.html"})
	public String listOwner(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
	
	@RequestMapping({"/find"})
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/findOwners";
	}
	
	@GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
	
	@GetMapping({"","/"})
	public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
		if(owner.getLastName() == null) {
			owner.setLastName("");
		}
		
		List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		
		if(owners.isEmpty()) {
			bindingResult.rejectValue("lastName", "notfound", "Not Found");
			return "owners/findOwners";
		} else if(owners.size() == 1) {
			owner = owners.get(0);
			return "redirect:/owners/" + owner.getId();
		} else {
			model.addAttribute("selections",owners);
			return "owners/ownersList";
		}
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("owner",Owner.builder().build());
		return "owners/createOrUpdateOwnerForm";
	}
	
	@PostMapping("/new")
	public String processCreationForm(@Validated Owner owner, BindingResult result) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}else {
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/"+savedOwner.getId();
		}
	}
	
	@GetMapping("/{ownerId}/edit")
	public String initEditForm(@PathVariable Long ownerId, Model model) {
		model.addAttribute("owner",ownerService.findById(ownerId));
		return "owners/createOrUpdateOwnerForm";
	}
	
	@PostMapping("/{ownerId}/edit")
	public String processEditForm(@Validated Owner owner, BindingResult result, @PathVariable Long ownerId) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}else {
			owner.setId(ownerId);
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/"+savedOwner.getId();
		}
	}
	
}
	 
