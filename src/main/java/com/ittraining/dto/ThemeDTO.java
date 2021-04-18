package com.ittraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeDTO {
	
	private Long id;
	private String libelle;
	private String description;
}
