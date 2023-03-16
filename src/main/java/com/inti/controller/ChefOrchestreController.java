package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	return "redirect/formChefO";
}

}
