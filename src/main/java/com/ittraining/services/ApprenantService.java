package com.ittraining.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.DemandeApprenantAuth;
import com.ittraining.dto.MessageApprenantAuth;
import com.ittraining.entities.Apprenant;
import com.ittraining.repositories.ApprenantRepository;

@Service
public class ApprenantService {

	@Autowired
	private ApprenantRepository repository;
	
	public Apprenant save(Apprenant entity) {
		try {
			return repository.save(entity);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	public List<Apprenant> findAll() {
		return repository.findAll();
	}

	
	

	

	public Apprenant findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public MessageApprenantAuth signin(DemandeApprenantAuth auth) {
		Optional<Apprenant> opt = this.repository.findByPasswordAndEmail(auth.getPassword(), auth.getEmail());
		if(opt.isPresent()) {
			Apprenant apprenant = opt.get();
			return new MessageApprenantAuth(apprenant.getId(), "Bien authentifier", true);
		}
		return new MessageApprenantAuth(-1l,"votre mots de passe ou identifiant invalide",false);
	}
	
}
