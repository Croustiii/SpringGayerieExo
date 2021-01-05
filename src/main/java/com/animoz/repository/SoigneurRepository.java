package com.animoz.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.entiteCorrection.Soigneur;


@Repository
public class SoigneurRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Soigneur> getListSoigneur(){
		return entityManager.createQuery("select s from Soigneur s order by s.nom", Soigneur.class)
							.getResultList();
		
	}
	
	@Transactional
	public void AddSoigneur(String nom, String numero, LocalDate dateRecrutement ) {
		Soigneur soigneur = new Soigneur();
		soigneur.setNom(nom);
		soigneur.setNumero(numero);
		soigneur.setDateRecrutement(dateRecrutement);
		entityManager.persist(soigneur);
	}
	
	
	
}
