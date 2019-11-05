package com.yilberk.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	
	private Long id;
	
	@NotNull
	private String projectName;
	
	@NotNull
	private String projectCode;

}
