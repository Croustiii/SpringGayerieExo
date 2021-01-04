package com.animoz.entiteCorrection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SoigneurCorr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String numero;
	private LocalDate dateRecrutement;

	@ManyToMany
	@JoinTable(name = "PopulationSoigneur", 
	           joinColumns = @JoinColumn(name = "soigneur_id"), 
	           inverseJoinColumns = @JoinColumn(name = "animal_id"))
	private List<AnimalCorr> animaux = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(LocalDate dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public List<AnimalCorr> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(List<AnimalCorr> animaux) {
		this.animaux = animaux;
	}
	
	public void addAnimal(AnimalCorr animal) {
		if(animal == null) {
			throw new NullPointerException("L'animal ne doit pas être nul");
		}
		if (! this.animaux.contains(animal)) {
			this.animaux.add(animal);
			animal.getSoigneurs().add(this);
		}
	}
}
