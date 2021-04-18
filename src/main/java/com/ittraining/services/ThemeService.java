package com.ittraining.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.ThemeDTO;
import com.ittraining.entities.Theme;
import com.ittraining.repositories.ThemeRepository;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository repository;

	public Theme save(Theme entity) {
		return repository.save(entity);
	}

	public List<ThemeDTO> findAll() {
		return ((List<Theme>) repository.findAll()).stream().map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public List<Theme> findByLibelle(String libelle) {
		return repository.findByLibelle(libelle);
	}

	public ThemeDTO findById(Long id) {
		Theme theme = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		ThemeDTO themeDto = new ThemeDTO();
		themeDto.setId(theme.getId());
		themeDto.setLibelle(theme.getLibelle());
		themeDto.setDescription(theme.getDescription());
		return themeDto;
	}
	
	public Boolean update(Theme theme, Long id) {
		Optional<Theme> themeOptional = this.repository.findById(id);
		if(themeOptional.isPresent()) {
			theme.setId(id);
			this.repository.save(theme);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean delete(Long id) {
		Optional<Theme> themeOptional = this.repository.findById(id);
		if(themeOptional.isPresent()) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	private ThemeDTO convertToDto(Theme theme) {
		ThemeDTO themeDto = new ThemeDTO();
		themeDto.setId(theme.getId());
		themeDto.setLibelle(theme.getLibelle());
		themeDto.setDescription(theme.getDescription());
		return themeDto;
	}
	
	private Theme convertToEntity(ThemeDTO themeDto) {
		Theme theme = new Theme();
		theme.setId(themeDto.getId());
		theme.setLibelle(themeDto.getLibelle());
		theme.setDescription(themeDto.getDescription());
		return theme;
	}
	
	
}
