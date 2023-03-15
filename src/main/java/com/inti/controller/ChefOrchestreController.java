package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;

@Controller
public class ChefOrchestreController {
	
	@Autowired
	IChefOrchestreRepository icor;
	
	@GetMapping("formChefOrchestre")
	public String formChefOrchestre()
	{
		
		return "formChefOrchestre";
	}
	
	@PostMapping("saveChefOrchestre")
	public String saveChefOrchestre(@ModelAttribute("ChefOrchestre") ChefOrchestre co)
	{
		icor.save(co);
		
		return "redirect:/formChefOrchestre";
	}
	
	@GetMapping("listeChefOrchestre")
	public String listeChefOrchestre(Model m)
	{
		m.addAttribute("listeCO", icor.findAll());
		
		return "listeChefOrchestre";
	}

}
