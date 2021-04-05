package com.ittraining.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name = "formation")
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="theme_id", referencedColumnName = "id")
	private Theme theme;
	
	@OneToMany(mappedBy = "formation", cascade = CascadeType.REMOVE)
	private List<Session> sessions = new ArrayList<>();

		

}
