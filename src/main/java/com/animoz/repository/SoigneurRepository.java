package com.animoz.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.entite.Soigneur;

@Repository
public class SoigneurRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Soigneur> getListSoigneur(){
		return entityManager.createQuery("select s from Soigneur s order by s.Nom", Soigneur.class)
							.getResultList();
		
	}
	
	@Transactional
	public void AddSoigneur(String nom, String numero, Date dateRecrutement ) {
		Soigneur soigneur = new Soigneur();
		soigneur.setNom(nom);
		soigneur.setNumero(numero);
		soigneur.setDateRecrutement(dateRecrutement);
		entityManager.persist(soigneur);
	}
	
	
	
}
