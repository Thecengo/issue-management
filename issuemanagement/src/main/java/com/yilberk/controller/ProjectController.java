package com.yilberk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.yilberk.util.ApiPaths;
import com.yilberk.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPaths.ProjectControllerPath.path)
@Api(value = ApiPaths.ProjectControllerPath.path, description = "project APIs")
@Slf4j
public class ProjectController {

	private final ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

//	@GetMapping("/pagination")
//	@ApiOperation(value = "pagination operation", response = TPage.class)
//	public ResponseEntity<TPage<ProjectDto>> getByPagination(Pageable pageable) {
//		TPage<ProjectDto> data = projectService.getAllPageable(pageable);
//		return ResponseEntity.ok(data);
//
//	}
	@GetMapping("/pagination")
	@ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
	public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
		TPage<ProjectDto> data = projectService.getAllPageable(pageable);
		return ResponseEntity.ok(data);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "get by id operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
		log.info("get by id -->" + id);
		ProjectDto projectDto = projectService.getById(id);
		return ResponseEntity.ok(projectDto);

	}

	@PostMapping()
	@ApiOperation(value = "create operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
		return ResponseEntity.ok(projectService.save(projectDto));

	}

	@PutMapping("/update/{id}")
	@ApiOperation(value = "update operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id,
			@Valid @RequestBody ProjectDto projectDto) {

		return ResponseEntity.ok(projectService.update(id, projectDto));

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete operation", response = Boolean.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

		return ResponseEntity.ok(projectService.delete(id));

	}

}
