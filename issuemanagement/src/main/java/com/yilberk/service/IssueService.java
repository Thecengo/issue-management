package com.yilberk.service;

import org.springframework.data.domain.Pageable;

import com.yilberk.dto.IssueDto;
import com.yilberk.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);
	
	TPage<IssueDto> getAllPageable(Pageable pageable);
	
	IssueDto update(Long id, IssueDto issueDto);
	
	Boolean delete(Long id);

}
