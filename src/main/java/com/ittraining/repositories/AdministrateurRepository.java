package com.ittraining.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long>{
	
	public Optional<Administrateur> findByEmailAndMotDePasse(String email, String motDePass);	
	public Administrateur findByNom(String nom);

}
