package com.animoz.entite;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Population {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long nombreIndividu;
	
	@OneToOne
	private Long animalId;
	
	
	//Getter Setter
	public Long getId() {
		return id;
	}
	
	public Long getNombreIndividu() {
		return nombreIndividu;
	}
	
	public Long getAnimalId() {
		return animalId;
	}
	
}
