package com.ittraining.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.DomaineDTO;
import com.ittraining.entities.Domaine;
import com.ittraining.repositories.DomaineRepository;

@Service
public class DomaineService {
	
	@Autowired
	private DomaineRepository repository;
	
	public Domaine save(Domaine entity) {
		return this.repository.save(entity);
	}
	
	public List<DomaineDTO> findAll() {
		return ((List<Domaine>) this.repository.findAll()).stream().map(this::convertToDTO)
				.collect(Collectors.toList());	
	}
	
	public DomaineDTO findById(Long id) {
		Domaine domaine = this.repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		DomaineDTO domaineDto = new DomaineDTO();
		domaineDto.setId(domaine.getId());
		domaineDto.setLibelle(domaine.getLibelle());
		return domaineDto;
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
	
	private DomaineDTO convertToDTO(Domaine domaine) {
		DomaineDTO domaineDto = new DomaineDTO();
		domaineDto.setId(domaine.getId());
		domaineDto.setLibelle(domaine.getLibelle());
		return domaineDto;
	}
	
	private Domaine convertToEntity(DomaineDTO domaineDto) {
		Domaine domaine = new Domaine();
		domaine.setId(domaineDto.getId());
		domaine.setLibelle(domaineDto.getLibelle());
		return domaine;
	}

}
