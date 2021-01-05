package com.animoz.dto;

import javax.validation.constraints.NotBlank;
import com.animoz.entiteCorrection.Regime;

public class AnimalDTO {

	private String nom;
	
	private String description;
	
	private Regime regime;
	
	private String espece;
	
	@NotBlank(message = "le nom de l'animal est obligatoire")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Regime getRegime() {
		return regime;
	}
	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	
	
	
	
}
