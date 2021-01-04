package com.animoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.dto.AnimalDTO;
import com.animoz.entite.Animal;
import com.animoz.service.AnimalService;

@Controller
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	
	@GetMapping(path = "/animaux")
	public String afficherListeAnimaux(Model model, @ModelAttribute("animal") AnimalDTO animalDto) {
		
		List<Animal> listeAnimaux = animalService.GetListAnimaux();
		
		
		model.addAttribute("listeAnimaux",listeAnimaux);

		
		return "ListeAnimaux";
	}
	
	@GetMapping(path = "/animal")
	public String afficherFormulaireCreation(@ModelAttribute("animal") AnimalDTO animalDto) {
		
		return"AddAnimalForm";
		
	}
	
	@PostMapping(path="/Animal")
	public String TraiterFormulaireRecherche(Model model, @Validated @ModelAttribute("animal") AnimalDTO animalDto, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return afficherFormulaireCreation(animalDto);
//		}
		
		String ResultatRecherche = animalService.GetAnimalByName(animalDto.getNom());
		
		model.addAttribute("resultatRecherche", ResultatRecherche);
		model.addAttribute("resultat",animalDto.getNom());
		
		return "ListeAnimaux";
	}
	
	@PostMapping(path="/PostAnimal")
	public String TraiterFormulaireCreationAnimal(Model model, @Validated @ModelAttribute("animal") AnimalDTO animalDto, BindingResult bindingResult) {
//			if (bindingResult.hasErrors()) {
//			return afficherFormulaireCreation(animalDto);
//		}
	
		animalService.AddAnimal(animalDto);
		
		return "AddAnimalForm";
	}

	
	
	
}
