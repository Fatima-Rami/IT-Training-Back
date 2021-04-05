package com.ittraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageApprenantAuth {

	private Long apprenantId;
	private String message;
	private boolean isAuth;
}
