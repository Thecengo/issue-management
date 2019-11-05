package com.yilberk.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yilberk.domain.Project;
import com.yilberk.dto.ProjectDto;


public interface ProjectService {
	
	Project save(Project project);
	
	ProjectDto getById(Long id);
	
	List<Project> getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	Page<Project> getAllPageable(Pageable pageable);
	
	Boolean delete(Project project);

}
