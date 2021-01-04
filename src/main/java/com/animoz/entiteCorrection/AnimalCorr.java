package com.animoz.entiteCorrection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnimalCorr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String origine;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private RegimeCorr regime;

	@ManyToOne
	@JoinColumn(name = "espece_id")
	private EspeceCorr espece;

	@ManyToMany(mappedBy = "animaux")
	private List<SoigneurCorr> soigneurs = new ArrayList<>();

	@OneToMany(mappedBy = "animal")
	private List<PopulationCorr> populations = new ArrayList<>();

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

	public RegimeCorr getRegime() {
		return regime;
	}

	public void setRegime(RegimeCorr regime) {
		this.regime = regime;
	}

	public EspeceCorr getEspece() {
		return espece;
	}

	public void setEspece(EspeceCorr espece) {
		this.espece = espece;
	}

	public List<SoigneurCorr> getSoigneurs() {
		return soigneurs;
	}

	public void setSoigneurs(List<SoigneurCorr> soigneurs) {
		this.soigneurs = soigneurs;
	}

	public List<PopulationCorr> getPopulations() {
		return populations;
	}

	public void setPopulations(List<PopulationCorr> populations) {
		this.populations = populations;
	}

}
