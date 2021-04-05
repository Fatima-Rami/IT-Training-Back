package com.ittraining.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Apprenant;



public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
	
	public Optional<Apprenant> findByPasswordAndEmail(String password, String email);
}
