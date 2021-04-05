package com.ittraining.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.FormationDTO;
import com.ittraining.entities.Formation;
import com.ittraining.repositories.FormationRepository;

@Service
public class FormationService {

	@Autowired
	private FormationRepository repository;

	public Formation save( Formation entity) {
		return repository.save(entity);
	}

	public List<FormationDTO> findAll() {
		return ((List<Formation>)repository
				.findAll())
				.stream()
				.map(this::convertToDto)
							.collect(Collectors.toList());
	}

	public List<Formation> findByTitre(String titre) {
		return repository.findByTitre(titre);
	}


	public Formation findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public FormationDTO findByIdToDTO(Long id) {
		Formation formation = this.findById(id);
		if(formation!=null) {
			return this.convertToDto(formation);
		} else {
			return null;
		}		
	}

	public void deleteById(Long id) {
		Optional<Formation> adminFound = this.repository.findById(id);
		if (adminFound.isPresent()) 
			this.repository.deleteById(id);
	}

	public FormationDTO convertToDto(Formation formation) {
		FormationDTO recupNewFormation = new FormationDTO(
				formation.getId(),
				formation.getTitre(),
				formation.getDescription()
				);
		return recupNewFormation;
	}
	
	public Formation convertToEntity(FormationDTO dto) {
		Formation formation = new Formation();
		formation.setId(dto.getId());
		formation.setTitre(dto.getTitre());
		formation.setDescription(dto.getDescription());
		return formation;
	}


}
