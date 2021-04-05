package com.ittraining.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.entities.Theme;
import com.ittraining.repositories.ThemeRepository;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository repository;

	public Theme save(Theme entity) {
		return repository.save(entity);
	}

	public List<Theme> findAll() {
		return repository.findAll();
	}

	
	
	public List<Theme> findByNom(String nom) {
		return repository.findByNom(nom);
	}

	public List<Theme> findByDescription(String description) {
		return repository.findByDescription(description);
	}

	public Theme findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	
	
	
}
