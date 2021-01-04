package com.animoz.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Soigneur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numero;
	
	private String Nom;
	
	private Date dateRecrutement;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String num) {
		this.numero= num;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	
	

	
}
