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
@Table(name = "theme")
public class Theme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="domaine_id", referencedColumnName = "id")
	private Domaine domaine;
	
	@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
	private List<Formation> formations = new ArrayList<>();

}
