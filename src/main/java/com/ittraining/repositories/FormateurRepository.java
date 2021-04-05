package com.ittraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {

	public List<Formateur> findByNom(String nom);

	public List<Formateur> findByNote(int note);

}
