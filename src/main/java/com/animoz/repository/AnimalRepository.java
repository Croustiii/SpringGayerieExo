package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.dto.AnimalDTO;
import com.animoz.entiteCorrection.Animal;
import com.animoz.entiteCorrection.Espece;

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
	public void AddAnimal(AnimalDTO animalDTO) {
		
		int countResult = this.GetAnimalByName(animalDTO.getNom()).size();
		
		// Creation de l'animal
		Animal animal = new Animal();
		animal.setNom(animalDTO.getNom());
		animal.setDescription(animalDTO.getDescription());
		animal.setRegime(animalDTO.getRegime());
		
		// Creation de l'espece saisie
		Espece espece = new Espece();
		espece.setNom(animalDTO.getEspece());
		animal.setEspece(espece);

		
		if (countResult==0) {
			entityManager.persist(animal);
		}
		else {
			System.out.println("Il existe déja un animal présent dans la base portant le même nom : " + animal.getNom());
		}
		
	}

	
}
