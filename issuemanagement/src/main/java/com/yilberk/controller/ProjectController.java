package com.yilberk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilberk.dto.ProjectDto;
import com.yilberk.service.ProjectService;


@RestController
@RequestMapping("/project")
public class ProjectController {

	private final ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
		ProjectDto projectDto = projectService.getById(id);
		return ResponseEntity.ok(projectDto);

	}

	@PostMapping()
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
		return ResponseEntity.ok(projectService.save(projectDto));

	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody ProjectDto projectDto) {

		return ResponseEntity.ok(projectService.update(id, projectDto));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

		return ResponseEntity.ok(projectService.delete(id));

	}

}
