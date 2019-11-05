package com.yilberk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yilberk.dataaccess.ProjectRepository;
import com.yilberk.domain.Project;
import com.yilberk.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Override
	public Project save(Project project) {
		if(project.getProjectCode() == null) {
			throw new IllegalArgumentException("object can't be null");
			
			
		}
		return projectRepository.save(project);
	}

	@Override
	public Project getById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.getOne(id);
	}

	@Override
	public List<Project> getByProjectCode(String projectCode) {
		// TODO Auto-generated method stub
		return projectRepository.getByProjectCode(projectCode);
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		// TODO Auto-generated method stub
		return projectRepository.getByProjectCodeContains(projectCode);
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

}
