package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.dto.AnimalDTO;
import com.animoz.entite.Animal;
import com.animoz.entite.Espece;
import com.animoz.entiteCorrection.AnimalCorr;
import com.animoz.entiteCorrection.EspeceCorr;

@Repository
public class AnimalRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Animal> getListAnimaux(){
		return entityManager.createQuery("select a from Animal a order by a.nom", Animal.class)
							.getResultList();
		
	}
	
	public List<Animal> GetAnimalByName(String nom) {
		List<Animal> animaux = entityManager.createQuery("select a from Animal a where lower(a.nom) = lower(:nom)", Animal.class)
                .setParameter("nom", nom)
                .getResultList();
		return animaux;
		
	}
	
	@Transactional
	public void AddAnimal(String nom, String description, String Regime, Espece espece) {
		Animal animal = new Animal();
		animal.setNom(nom);
		animal.setDescription(description);
		animal.setRegime(Regime);
		animal.setEspece_id(espece);
		entityManager.persist(animal);
		
	}
	
	
	@Transactional
	public void AddAnimalCorrection(AnimalDTO animalDTO) {
		
		int countResult = this.GetAnimalByName(animalDTO.getNom()).size();
		
		if (countResult==0) {
			// Creation de l'animal
			AnimalCorr animal = new AnimalCorr();
			animal.setNom(animalDTO.getNom());
			animal.setDescription(animalDTO.getDescription());
			animal.setRegime(animalDTO.getRegime());
			EspeceCorr espece = new EspeceCorr();
			espece.setNom(animalDTO.getEspece());
			animal.setEspece(espece);
			
			entityManager.persist(animal);

		}
		else {
			System.out.println("il existe déja un animal présent dans la base portant le même nom");
		}
		
	}

	
}
