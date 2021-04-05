package com.ittraining.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.entities.Domaine;
import com.ittraining.repositories.DomaineRepository;

@Service
public class DomaineService {
	
	@Autowired
	private DomaineRepository repository;
	
	public Domaine save(Domaine entity) {
		return this.repository.save(entity);
	}
	
	public List<Domaine> findAll() {
		return this.repository.findAll();
	}
	
	public Domaine findById(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Boolean updateDomaine(Domaine domaine, Long id) {
		Optional<Domaine> domaineFound = this.repository.findById(id);
		if (domaineFound.isPresent()) {
			domaine.setId(id);
			this.repository.save(domaine);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean delete(Long id) {
		Optional<Domaine> domaineFound = this.repository.findById(id);
		if (domaineFound.isPresent()) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
