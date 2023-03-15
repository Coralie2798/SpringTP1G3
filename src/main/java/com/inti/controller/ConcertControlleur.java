package com.inti.controller;z

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;

@Controller
public class ConcertControlleur {
	
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
		return "redirect/formConcert";
	}
}
