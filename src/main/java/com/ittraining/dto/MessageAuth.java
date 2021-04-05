package com.ittraining.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageAuth {
	
	private Long adminId;
	private String message;
	private Boolean isAuth;

}
