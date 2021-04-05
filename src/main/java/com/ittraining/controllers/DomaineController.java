package com.ittraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.entities.Domaine;
import com.ittraining.services.DomaineService;

@RestController
@CrossOrigin
@RequestMapping("domaines")
public class DomaineController {
	
	@Autowired
	private DomaineService service;
	
	@PostMapping("")
	public Domaine save(@RequestBody Domaine entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("")
	public List<Domaine> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Domaine findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PutMapping("{id}")
	public Boolean update(@RequestBody Domaine domaine, @PathVariable Long id) {
		return this.service.updateDomaine(domaine, id);
	}
	
	@DeleteMapping("{id}")
	public Boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
