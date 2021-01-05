package com.animoz.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.entiteCorrection.Soigneur;
import com.animoz.repository.SoigneurRepository;

@Service
public class SoigneurService {

	@Autowired
	private  SoigneurRepository soigneurRepository;
	
	public List<Soigneur> GetListSoigneur(){
		return soigneurRepository.getListSoigneur();
	}
	
	public void AddSoigneur(String nom, String numero, LocalDate dateRecrutement) {
		soigneurRepository.AddSoigneur(nom, numero, dateRecrutement);
	}
	
	
}
