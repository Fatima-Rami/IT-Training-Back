package com.ittraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.entities.Formateur;
import com.ittraining.services.FormateurService;

@RestController
@RequestMapping("formateur")
@CrossOrigin
public class FormateurController {
	
	@Autowired
	private FormateurService service;
	
	@PostMapping("")
	public Formateur save(@RequestBody Formateur entity) {
		return this.service.save(entity);
	}

	@GetMapping("nom/{nom}")
	public List<Formateur> findByNom(@PathVariable String nom) {
		return service.findByNom(nom);
	}

	@GetMapping("note/{note}")
	public List<Formateur> findByNote(@PathVariable int note) {
		return service.findByNote(note);
	}

	@GetMapping("{id}")
	public Formateur findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
