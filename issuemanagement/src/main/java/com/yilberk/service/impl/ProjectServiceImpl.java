package com.yilberk.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yilberk.dataaccess.ProjectRepository;
import com.yilberk.domain.Project;
import com.yilberk.domain.User;
import com.yilberk.dto.ProjectDto;
import com.yilberk.dto.UserDto;
import com.yilberk.service.ProjectService;
import com.yilberk.service.UserService;
import com.yilberk.util.TPage;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	private final UserService userService;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository
			, ModelMapper modelMapper
			, UserService userService) {
		this.modelMapper = modelMapper;
		this.projectRepository = projectRepository;
		this.userService = userService;
	}
	
	@Override
	public ProjectDto save(ProjectDto projectDto) {
		
		Project projectCodeCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
		
		if(projectCodeCheck != null) {
			throw new IllegalArgumentException("project code can not be same");
		}
		
		Project project = modelMapper.map(projectDto,Project.class);
		UserDto user = userService.getById(projectDto.getId());
		projectDto.setManager(user);
		
		System.out.print("project dto manager"+projectDto.getManager());
	
		project = projectRepository.save(project);
		projectDto.setId(project.getId());
		
		
		return projectDto;
	}

	@Override
	public ProjectDto getById(Long id) {
	   Project project = projectRepository.getOne(id);
	   return modelMapper.map(project, ProjectDto.class);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		// TODO Auto-generated method stub
		//return projectRepository.getByProjectCode(projectCode);
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		// TODO Auto-generated method stub
		return projectRepository.getByProjectCodeContains(projectCode);
	}

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
        
    }

	@Override
	public ProjectDto update(Long id, ProjectDto projectDto) {
		Project projectDb = projectRepository.getOne(id);
		if(projectDb == null) {
			throw new IllegalArgumentException("Id was not found"+id);
		}
		
		Project projectCodeCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);
		if(projectCodeCheck != null) {
			throw new IllegalArgumentException("project code can not be same");
		}
		
		projectDb.setProjectCode(projectDto.getProjectCode());
	    projectDb.setProjectName(projectDto.getProjectName());
	    
	    projectRepository.save(projectDb);
		
		return modelMapper.map(projectDb, ProjectDto.class);
	}

	@Override
	public Boolean delete(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return true;
	}

}
