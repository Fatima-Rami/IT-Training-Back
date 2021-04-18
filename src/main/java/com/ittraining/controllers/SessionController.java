package com.ittraining.controllers;

import java.text.ParseException;
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

import com.ittraining.dto.SessionDTO;
import com.ittraining.entities.Session;
import com.ittraining.services.SessionService;

@RestController
@CrossOrigin
@RequestMapping("sessions")
public class SessionController {

	@Autowired
	private SessionService service;

	@PostMapping("")
	public Session save(@RequestBody SessionDTO sessionDTO) throws ParseException {
		return service.save(sessionDTO);
	}

	@GetMapping("")
	public List<SessionDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	public SessionDTO findById(@PathVariable Long id) {
	return service.findById(id);
    }
	
	@PutMapping("{id}")
	public Boolean update(@RequestBody Session session, @PathVariable Long id) {
		return this.service.update(session, id);
	}
	
	@DeleteMapping("{id}")
	public Boolean deleteById(@PathVariable Long id) {
		return this.service.deleteById(id);
	}
	
}
