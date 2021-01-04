package com.animoz.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.dto.AnimalDTO;
import com.animoz.dto.SoigneurDTO;
import com.animoz.entite.Soigneur;
import com.animoz.service.SoigneurService;

@Controller
public class SoigneurController {
	
	@Autowired
	private SoigneurService soigneurService;
	
	@GetMapping(path = "/soigneur")
	public String afficherListeAnimaux(Model model) {
		
		List<Soigneur> listeSoigneur = soigneurService.GetListSoigneur();
		//soigneurService.AddSoigneur("toto", "S050505", new Date(1950,11,1));
		
		model.addAttribute("listeSoigneur",listeSoigneur);
		
		return "listeSoigneur";
	}
	
	@GetMapping(path = "/ajouterSoigneur")
	public String afficherPageAjoutSoigneur(Model model, @Validated @ModelAttribute("soigneur") SoigneurDTO soigneurDto, BindingResult bindingResult) {
		
		return "AddSoigneurForm";
	}
	
	@PostMapping(path = "/AddSoigneur")
	public String traiterFormulaireAjoutSoigneur(Model model, @Validated @ModelAttribute("soigneur") SoigneurDTO soigneurDto, BindingResult bindingResult) {
		
		soigneurService.AddSoigneur(soigneurDto.getNom(), 
									soigneurDto.getNumero(), 
									soigneurDto.getDateRecrutement());
		
		
		return "AddSoigneurForm";
	}
	
	
	
}
