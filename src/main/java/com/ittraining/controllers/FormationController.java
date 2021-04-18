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

import com.ittraining.dto.FormationDTO;
import com.ittraining.entities.Formation;
import com.ittraining.services.FormationService;

@RestController
@RequestMapping("formations")
@CrossOrigin
public class FormationController {

	@Autowired
	private FormationService service;
	
	@GetMapping("")
	public List<FormationDTO> findAll(){
		List<FormationDTO> formationDTO = service.findAll();	
		return formationDTO;
	}
	
	@PostMapping("")
	public Formation save(@RequestBody Formation entity) {
		return this.service.save(entity);
	}
	
	
	@GetMapping("titre/{titre}")
	public List<Formation> findByTitre(@PathVariable String titre) {
		return service.findByTitre(titre);
	}
	

	@GetMapping("{id}")
	public FormationDTO findById(@PathVariable Long id) {
		return service.findByIdDTO(id);
	}
	
	@PutMapping("{id}")
	public Boolean update(@RequestBody Formation formation, @PathVariable Long id) {
		return this.service.update(formation, id);
	}

	@DeleteMapping("{id}")
	public Boolean deleteById(@PathVariable Long id) {
		return this.service.deleteById(id);
	}
	
	
	
}
