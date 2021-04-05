package com.ittraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationDTO {

	private Long id;
	private String titre;
	private String description;

}
