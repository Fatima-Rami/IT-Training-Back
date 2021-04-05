package com.ittraining.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
	
	private Long id;
	private String dateDebut;
	private String dateFin;
	private String prix;
	private String lieu;
	private String status;
	private FormationDTO formation;

}
