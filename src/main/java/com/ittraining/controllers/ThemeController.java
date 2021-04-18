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

import com.ittraining.dto.ThemeDTO;
import com.ittraining.entities.Theme;
import com.ittraining.services.ThemeService;

@RestController
@RequestMapping("themes")
@CrossOrigin
public class ThemeController {
	
	@Autowired
	private ThemeService service;

	@PostMapping ("")
	public Theme save(@RequestBody Theme entity) {
		return service.save(entity);
	}

	@GetMapping("")
	public List<ThemeDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/recherche/{libelle}")
	public List<Theme> findByLibelle(@PathVariable String libelle) {
		return service.findByLibelle(libelle);
	}


	@GetMapping ("{id}")
	public ThemeDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("{id}")
	public Boolean update(@RequestBody Theme theme, @PathVariable Long id) {
		return service.update(theme, id);
	}
	
	@DeleteMapping("{id}")
	public Boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}
	
}
