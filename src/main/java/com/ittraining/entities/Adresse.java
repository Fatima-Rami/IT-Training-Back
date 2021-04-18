package com.ittraining.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table
public class Adresse{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private int numeroVoie;
	
	@Column
	private String mentionNumero;
	
	@Column
	private String typeVoie;
	
	@Column
	private String libelleVoie;
	
	@Column
	private String completment;
	
	@Column
	private int codePostal;
	
	@Column
	private String ville;

}
