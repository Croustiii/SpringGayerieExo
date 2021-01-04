package com.animoz.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String origine;
	private String description;
	private String regime;
	
	@ManyToOne
	private Espece espece;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Espece getEspece() {
		return espece;
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
	}
	
	public Espece getEspece_id() {
		return espece;
	}
	public void setEspece_id(Espece espece_id) {
		this.espece = espece_id;
	}
	
}
