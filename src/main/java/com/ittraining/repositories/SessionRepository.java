package com.ittraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	public List<Session> findByFormationId(Long id);
	public List<Session> findByStatus(String statusInput);	
}
