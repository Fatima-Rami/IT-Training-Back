package com.ittraining.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.DemandeAuth;
import com.ittraining.dto.MessageAuth;
import com.ittraining.entities.Administrateur;
import com.ittraining.repositories.AdministrateurRepository;

@Service
public class AdministrateurService {
	
	
	@Autowired
	private AdministrateurRepository repository;
	
	public Administrateur save(Administrateur entity) {
		return this.repository.save(entity);
	}
	
	public List<Administrateur> findAll() {
		return this.repository.findAll();
	}
	
	public Administrateur findById(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public MessageAuth signin(DemandeAuth auth) {
		Optional<Administrateur> adminOptional = this.repository.findByEmailAndMotDePasse(auth.getEmail(), auth.getPassword());
		if (adminOptional.isPresent()) {
			Administrateur administrateur = adminOptional.get();
			return new MessageAuth(administrateur.getId(), "Authentification de l'administrateur réussie", true);
		}
		return new MessageAuth(-1L, "Echec de l'authentificaton", false);
	}
		
	public Boolean updateAdministrateur(Administrateur administrateur, Long id) {
		Optional<Administrateur> adminFound = this.repository.findById(id);
		if (adminFound.isPresent()) {
			administrateur.setId(id);
			 this.repository.save(administrateur);
			 return true;
		} else {
			return false;
		}
	}
	
	public Boolean deleteById(Long id) {
		Optional<Administrateur> adminFound = this.repository.findById(id);
		if (adminFound.isPresent()) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}


}
