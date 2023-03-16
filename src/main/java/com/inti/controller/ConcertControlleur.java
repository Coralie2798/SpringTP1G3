package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Concert;
import com.inti.model.Soliste;
import com.inti.repository.IConcertRepository;

@Controller
public class ConcertControlleur {
	
	@Autowired
	IConcertRepository icrt;
	
	@GetMapping("formConcert")
	public String formConcert()
	{
		return "formConcert";
	}

	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("concert") Concert c)
	{
		icrt.save(c);
		return "formConcert";
	}
	

	@GetMapping("listeConcert")
	public String listeConcert(Model m)
	{
		
		m.addAttribute("listeC", icrt.findAll());
		return "listeConcert";
	}
	
	@GetMapping("deleteConcert/{id}")
	public String deleteConcert(@PathVariable("id") int idC) {
		icrt.deleteById(idC);
		
		return "redirect:/listeConcert";
	}
	

	@GetMapping("modifConcert/{id}")
	public String modifSoliste(@PathVariable("id") int idC, Model m) 
	{
		m.addAttribute("concert", icrt.getReferenceById(idC));
		System.out.println(m);
		return "modifConcert";
	}
	
	@PostMapping("modifConcert")
	public String updateSoliste(@ModelAttribute("concert") Concert c) {
		
		icrt.save(c);
		
		return "redirect:/listeSoliste";
	}
}
