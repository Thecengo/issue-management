package com.yilberk.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Project data transfer object")
public class ProjectDto {
	
	@ApiModelProperty(value = "Project id")
	private Long id;
	
	@NotNull
	@ApiModelProperty(required = true, value = "Name of Project")
	private String projectName;
	
	@NotNull
	@ApiModelProperty(required = true, value = "Code of Project")
	private String projectCode;
	
	@NotNull
	@ApiModelProperty(required = true, value = "Manager id  of Project")
	private Long managerId;
	
//	@NotNull
//	@ApiModelProperty(required = true, value = "Manager of project")
	private UserDto manager;

}
