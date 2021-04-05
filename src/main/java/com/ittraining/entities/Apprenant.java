/**
 * 
 */
package com.ittraining.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author IB
 *
 */
@Data
@Entity
@Table
public class Apprenant {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	private String password;
	
	

}
