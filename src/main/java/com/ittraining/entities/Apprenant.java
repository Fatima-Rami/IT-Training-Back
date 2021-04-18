/**
 * 
 */
package com.ittraining.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author IB
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table
public class Apprenant extends Personne{
	
	@Column
	private String password;
	
	@ManyToOne
	private Adresse adresse;
}
