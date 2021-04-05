package com.ittraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	public List<Formation> findByTitre(String titre);

	

}
