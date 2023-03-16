package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.inti.repository.ISolisteRepository;

@Controller
public class SolisteController {

	@Autowired
	ISolisteRepository isr;
	
	@GetMapping("formSoliste")
	public String formSoliste() {
		return "formSoliste";
	}
}
