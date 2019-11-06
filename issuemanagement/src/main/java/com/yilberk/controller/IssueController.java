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

import com.yilberk.dto.IssueDto;
import com.yilberk.dto.ProjectDto;
import com.yilberk.service.IssueService;
import com.yilberk.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.IssueControllerPath.path)
@Api(value = ApiPaths.IssueControllerPath.path,description= "issue APIs")
public class IssueController {

	private final IssueService issueService;

	@Autowired
	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "get by id operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
		IssueDto issueDto = issueService.getById(id);
		return ResponseEntity.ok(issueDto);

	}

	@PostMapping()
	@ApiOperation(value = "crate operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto) {
		return ResponseEntity.ok(issueService.save(issueDto));

	}
	@PutMapping("/update/{id}")
	@ApiOperation(value = "update operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody IssueDto issueDto) {

		return ResponseEntity.ok(issueService.update(id, issueDto));

	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete operation", response = IssueDto.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

		return ResponseEntity.ok(issueService.delete(id));

	}

}
