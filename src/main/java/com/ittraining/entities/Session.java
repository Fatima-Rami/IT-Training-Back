package com.ittraining.entities;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Entity
@Table(name="session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="date_debut")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy", timezone="UTC")
    @Temporal(TemporalType.DATE)
	private Date date_debut;

	@Column(name="date_fin")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy", timezone="UTC")
    @Temporal(TemporalType.DATE)
	private Date date_fin;

	@Column(name="prix")
	private String prix;

	@Column(name="lieu")
	private String lieu;
	
	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name="formation_id", referencedColumnName = "id")
	private Formation formation;



}
