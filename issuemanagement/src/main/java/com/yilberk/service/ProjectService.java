package com.yilberk.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.yilberk.domain.Project;
import com.yilberk.dto.ProjectDto;
import com.yilberk.util.TPage;


public interface ProjectService {
	
	ProjectDto save(ProjectDto projectDto);
	
	ProjectDto getById(Long id);
	
	ProjectDto update(Long id, ProjectDto projectDto);
	
	ProjectDto getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	TPage<ProjectDto> getAllPageable(Pageable pageable);
	
	Boolean delete(ProjectDto projectDto);
	
	Boolean delete(Long id);
	
	

}
