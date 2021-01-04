package com.animoz.dto;

import javax.validation.constraints.NotBlank;
import com.animoz.entiteCorrection.RegimeCorr;

public class AnimalDTO {

	private String nom;
	
	private String description;
	
	private RegimeCorr regime;
	
	private String Espece;
	
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
	
	public RegimeCorr getRegime() {
		return regime;
	}
	public void setRegime(RegimeCorr regime) {
		this.regime = regime;
	}
	
	public String getEspece() {
		return Espece;
	}
	public void setEspece(String espece) {
		Espece = espece;
	}
	
	
	
	
	
}
