package com.umanis.jean.poc_jsf.poc_projet_jsf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umanis.jean.poc_jsf.poc_projet_jsf.bean.Personne;

public interface IPersonneRepositories extends JpaRepository<Personne, Integer> {
	
	Personne findByPrenomAndNom(String prenom, String nom);

}
