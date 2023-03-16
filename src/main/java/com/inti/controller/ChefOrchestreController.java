package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;

@Controller
public class ChefOrchestreController {
@Autowired
IChefOrchestreRepository ichefr;


@GetMapping("formChefO")
public String formChefO()
{
	return "formChefO";
}

@PostMapping("saveChefO")
public String saveChefO(@ModelAttribute("ChefO") ChefOrchestre co)
{
	ichefr.save(co);
	return "redirect:/formChefO";
}

@GetMapping("listeChefOrchestre")
public String listeChefOrchestre(Model m)
{
	m.addAttribute("listeChefOrchestre", ichefr.findAll());
	
	return "listeChefOrchestre";
}

@GetMapping("deleteChefOrchestre/{id}")
public String deleteChefOrchestre(@PathVariable("id") int id)
{
	ichefr.deleteById(id);
	
	return "redirect:/listeChefOrchestre";
}

@GetMapping("modifChefOrchestre/{id}")
public String modifChefOrchestreVoiture(@PathVariable("id") int id, Model m)
{
	m.addAttribute("ChefOrchestre", ichefr.getReferenceById(id));
	
	return "modifChefOrchestre";
}

@PostMapping("updateChefOrchestre")
public String updateChefOrchestre(@ModelAttribute("ChefOrchestre") ChefOrchestre co)
{ 

	ichefr.save(co);
	
	return "redirect:/listeChefOrchestre";
}

}
