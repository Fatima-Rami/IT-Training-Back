package com.ittraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
	
	private Long id;
	private int numeroVoie;
	private String mentionNumero;
	private String typeVoie;
	private String libelleVoie;
	private String complement;
	private int codePostal;
	private String ville;

}
