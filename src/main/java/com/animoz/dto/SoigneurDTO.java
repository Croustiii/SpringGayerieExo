package com.animoz.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;

public class SoigneurDTO {
	
	
	public String numero;
	
	public String nom;
	
	public LocalDate dateRecrutement;
	
	
	@NotBlank(message = "Le numéro est obligatoire !")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@NotBlank(message = "Le nom est obligatoire !")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//@NotBlank(message = "La date de recrutement est obligatoire !")
	public LocalDate getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(LocalDate dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	
	
}
