package com.yilberk.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yilberk.domain.Project;
import com.yilberk.dto.ProjectDto;


public interface ProjectService {
	
	ProjectDto save(ProjectDto projectDto);
	
	ProjectDto getById(Long id);
	
	ProjectDto update(Long id, ProjectDto projectDto);
	
	ProjectDto getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	Page<Project> getAllPageable(Pageable pageable);
	
	Boolean delete(ProjectDto projectDto);
	
	Boolean delete(Long id);
	
	

}
