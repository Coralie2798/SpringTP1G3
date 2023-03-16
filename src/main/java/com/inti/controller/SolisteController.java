package com.inti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.inti.model.Oeuvre;
import com.inti.model.Soliste;
import com.inti.repository.IOeuvreRepository;
import com.inti.repository.ISolisteRepository;

@Controller
public class SolisteController {

	@Autowired
	ISolisteRepository isr;
	
	@Autowired
	IOeuvreRepository ior;
	
	@GetMapping("formSoliste")
	public String formSoliste() {
		return "formSoliste";
	}
	
	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste s) {
		
		isr.save(s);
		return "redirect:/listeSoliste";
	}
	
	@GetMapping("listeSoliste")
	public String listeSoliste(Model m)
	{
		
		m.addAttribute("listeS", isr.findAll());
		return "listeSoliste";
	}
	
	@GetMapping("deleteSoliste/{nSoliste}")
	public String deleteSoliste(@PathVariable("nSoliste") int id) {
		isr.deleteById(id);
		
		return "redirect:/listeSoliste";
	}
	

	@GetMapping("modifSoliste/{nSoliste}")
	public String modifSoliste(@PathVariable("nSoliste") int id, Model m) 
	{
		m.addAttribute("soliste", isr.getReferenceById(id));
		
		return "modifSoliste";
	}
	
	@PostMapping("modifSoliste")
	public String updateSoliste(@ModelAttribute("soliste") Soliste s) {
		
		isr.save(s);
		
		return "redirect:/listeSoliste";
	}

	@GetMapping("formOeuvre")
	public String formOeuvre() {
		return "formOeuvre";
	}
	
	@PostMapping("saveOeuvre")
	public String saveOeuvre(@ModelAttribute("oeuvre") Oeuvre o) {
		ior.findById(o.getNOeuvre());
		ior.save(o);
		return "redirect:/listeOeuvre";
	}
	@GetMapping("listeOeuvre")
	public String listeOeuvre(Model m)
	{
		
		m.addAttribute("listeO", ior.findAll());
		return "listeOeuvre";
	}
	@GetMapping("deleteOeuvre/{nOeuvre}")
	public String deleteOeuvre(@PathVariable("nOeuvre") int id) {
		ior.deleteById(id);
		
		return "redirect:/listeOeuvre";
	}
	
	@GetMapping("modifOeuvre/{nOeuvre}")
	public String modifOeuvre(@PathVariable("nOeuvre") int id, Model m) 
	{
		m.addAttribute("oeuvre", ior.getReferenceById(id));
		
		return "modifOeuvre";
	}
	
	@PostMapping("modifOeuvre")
	public String updateOeuvre(@ModelAttribute("oeuvre") Oeuvre o) {
		
		ior.save(o);
		
		return "redirect:/listeOeuvre";
	}
	
	@GetMapping("Oeuvre_Soliste")
	public String OeuvreSoliste(Model m)
	{
		
		
	
		m.addAttribute("listeS", isr.findAll());
		m.addAttribute("listeO", ior.findAll());
		
		return "Oeuvre_Soliste";
	}
	
	@PostMapping("Oeuvre_Soliste")
	public String OeuvreToSoliste(@RequestParam("selectedOeuvre") List<Integer>listeIdO,
			@RequestParam("selectedSoliste")List<Integer>listeIdS) 
	{
//		
//		List<Soliste>listeSolistes= new ArrayList<>();
//		
//		for(Integer idS:listeIdS) {
//			listeSolistes.add(isr.findById(idS));
//			
//		}
//		
//		List<Magasin>listeMagasins=new ArrayList<>();
//		
//		for(Integer idM: listeIdM) {
//			listeMagasins.add(ims.getMagasin(idM));
//		}
//		
//		for(Magasin magasin: listeMagasins) {
//			for (Produit produit : magasin.getListeProduits()) {
//				listeProduit.add(produit);
//				
//			}
//			magasin.setListeProduits(listeProduit);
//			ims.updateMagasin(magasin);
//		}
		return "redirect:/admin/associerProduitsToMagasins";
	}
	
}
