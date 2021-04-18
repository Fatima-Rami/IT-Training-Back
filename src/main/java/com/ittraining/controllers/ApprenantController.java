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

import com.ittraining.dto.DemandeApprenantAuth;
import com.ittraining.dto.MessageApprenantAuth;
import com.ittraining.entities.Apprenant;
import com.ittraining.services.ApprenantService;

@RestController
@RequestMapping("apprenants")
@CrossOrigin
public class ApprenantController {

	@Autowired
	private ApprenantService service;
	
	@PostMapping("")
	public Apprenant save(@RequestBody Apprenant entity) {
		return service.save(entity);
	}

	@GetMapping("")
	public List<Apprenant> findAll() {
		return service.findAll();
	}
	
    @GetMapping("{id}")
	public Apprenant findById(@PathVariable Long id) {
		return service.findById(id);
	}
    
    @PostMapping("signin")
    public MessageApprenantAuth signin(@RequestBody DemandeApprenantAuth auth) {
    	return service.signin(auth);
    }
    
	
	
}
