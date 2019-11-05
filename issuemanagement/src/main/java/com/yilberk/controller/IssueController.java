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
import com.yilberk.service.IssueService;
import com.yilberk.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.IssueControllerPath.path)
public class IssueController {

	private final IssueService issueService;

	@Autowired
	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
		IssueDto issueDto = issueService.getById(id);
		return ResponseEntity.ok(issueDto);

	}

	@PostMapping()
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto) {
		return ResponseEntity.ok(issueService.save(issueDto));

	}
	@PutMapping("/update/{id}")
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody IssueDto issueDto) {

		return ResponseEntity.ok(issueService.update(id, issueDto));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

		return ResponseEntity.ok(issueService.delete(id));

	}

}
