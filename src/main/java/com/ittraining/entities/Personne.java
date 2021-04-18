package com.ittraining.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Personne {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String email;
	
	@Column
	private String telephone;
	
	@Column
	private Adresse adresse;

}
