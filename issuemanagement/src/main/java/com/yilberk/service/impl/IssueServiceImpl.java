package com.yilberk.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yilberk.dataaccess.IssueRepository;
import com.yilberk.domain.Issue;
import com.yilberk.domain.Project;
import com.yilberk.dto.IssueDto;
import com.yilberk.dto.ProjectDto;
import com.yilberk.service.IssueService;
import com.yilberk.util.TPage;

@Service
public class IssueServiceImpl implements IssueService{
	
	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.issueRepository = issueRepository;
	}

	@Override
	public IssueDto save(IssueDto issueDto) {
		if(issueDto.getDate() == null)
			throw new IllegalArgumentException("issue can not be null");
		Issue issue = modelMapper.map(issueDto, Issue.class);
		
		issue = issueRepository.save(issue);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue = issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage<IssueDto> page = new TPage<IssueDto>();
		IssueDto [] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
		page.setStat(data, Arrays.asList(dtos));
		return page;
	}

	@Override
	public Boolean delete(Long id) {
		issueRepository.deleteById(id);
		return true;
	}

	@Override
	public IssueDto update(Long id, IssueDto issueDto) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
