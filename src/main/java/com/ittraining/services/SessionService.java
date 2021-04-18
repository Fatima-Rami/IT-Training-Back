package com.ittraining.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.FormationDTO;
import com.ittraining.dto.SessionDTO;
import com.ittraining.entities.Formation;
import com.ittraining.entities.Session;
import com.ittraining.repositories.SessionRepository;
import com.ittraining.utils.ConvertionDate;
import com.ittraining.utils.session.VerifyDateSession;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;
	
	@Autowired
	private FormationService formationService;
	
	public Session save(SessionDTO sessionDTO) throws ParseException {	
		Session entity = this.convertToEntity(sessionDTO);
		
		if (VerifyDateSession.isDateAfterToday(entity.getDate_debut()) 
				&& VerifyDateSession.isDateBeginBeforeDateEnd(entity.getDate_debut(), entity.getDate_fin())) {
			return repository.save(entity);
		} else {
			return new Session();
		}
		
	}

	public List<SessionDTO> findAll() {
		return ((List<Session>) repository.findAll()).stream().map(this::convertToSessionDto)
				.collect(Collectors.toList());
	}

	public SessionDTO findById(Long id) {
		Session session = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		SessionDTO sessionDto = new SessionDTO();
		sessionDto.setId(session.getId());
		String dateDebut = ConvertionDate.convertDateToString(session.getDate_debut());
		String dateFin = ConvertionDate.convertDateToString(session.getDate_fin());
		sessionDto.setDateDebut(dateDebut);
		sessionDto.setDateFin(dateFin);
		sessionDto.setLieu(session.getLieu());
		sessionDto.setPrix(session.getPrix());
		sessionDto.setStatus(session.getStatus());
		FormationDTO formationDto = formationService.convertToDto(session.getFormation());
		sessionDto.setFormation(formationDto);
		return sessionDto;
	}

	
	public List<SessionDTO> findByStatus(String statusInput) {
		return this.repository.findByStatus(statusInput).stream().map(this::convertToSessionDto)
				.collect(Collectors.toList());
	}
	
	public List<Session> findByFormationId(Long id) {
		return repository.findByFormationId(id);
	}

	public List<SessionDTO> findByFormationIdDTO(Long id) {
		return ((List<Session>)repository
				.findByFormationId(id))
				.stream()
				.map(this::convertToSessionDto)
							.collect(Collectors.toList());
	}
	
	public Boolean update(Session session, Long id) {
		Optional<Session> sessionFound = this.repository.findById(id);		
		if(sessionFound.isPresent()) {
			session.setId(id);
			session.setDate_debut(sessionFound.get().getDate_debut());
			session.setDate_fin(sessionFound.get().getDate_fin());
			this.repository.save(session);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean deleteById(Long id) {
		Optional<Session> sessionOptional = this.repository.findById(id);
		if (sessionOptional.isPresent()) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}		
	}
	
	private SessionDTO convertToSessionDto(Session session) {
		SessionDTO sessionDto = new SessionDTO();
		sessionDto.setId(session.getId());			
		String dateDebut = ConvertionDate.convertDateToString(session.getDate_debut());
		String dateFin = ConvertionDate.convertDateToString(session.getDate_fin());
		
		sessionDto.setDateDebut(dateDebut);
		sessionDto.setDateFin(dateFin);
		sessionDto.setPrix(session.getPrix());
		sessionDto.setLieu(session.getLieu());
		
		FormationDTO formationDTO = this.formationService.convertToDto(session.getFormation());
		sessionDto.setFormation(formationDTO);
		return sessionDto;
	}
	
	private Session convertToEntity(SessionDTO sessionDTO) throws ParseException {
		Session session = new Session();
		Date dateDebut = ConvertionDate.convertStringToDate(sessionDTO.getDateDebut());
		Date dateFin = ConvertionDate.convertStringToDate(sessionDTO.getDateFin());
		
		session.setDate_debut(dateDebut);
		session.setDate_fin(dateFin);
		session.setPrix(sessionDTO.getPrix());
		session.setLieu(sessionDTO.getLieu());
		
		Formation formation = this.formationService.convertToEntity(sessionDTO.getFormation());
		session.setFormation(formation);
		return session;
	}

}
