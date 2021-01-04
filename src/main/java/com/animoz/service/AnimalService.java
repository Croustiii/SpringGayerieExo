package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.dto.AnimalDTO;
import com.animoz.entite.Animal;
import com.animoz.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private  AnimalRepository animalRepository;
	
	public List<Animal> GetListAnimaux(){
		return animalRepository.getListAnimaux();
	}
	
	public String GetAnimalByName(String nom){
		List<Animal> result = animalRepository.GetAnimalByName(nom);
		
		if (result.isEmpty()) {
			return "L'animal recherché n'existe pas. ";
		}
		else if(result.size()>1) {
			return "Il existe  " + result.size() + " animaux de ce nom dans la base de données." ;
		}
		else if(result.size() == 1) {
			return "L'animal recherché est présent dans la base de données.";
		}
		return "";
	}
	
	public void AddAnimal(AnimalDTO animal) {
		
		animalRepository.AddAnimalCorrection(animal);
	}
	
	
	
	
	
}
