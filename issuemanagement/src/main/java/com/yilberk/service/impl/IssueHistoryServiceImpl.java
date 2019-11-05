package com.yilberk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yilberk.dataaccess.IssueHistoryRepository;
import com.yilberk.domain.IssueHistory;
import com.yilberk.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService{

	private final IssueHistoryRepository issueHistoryRepository;
	
	@Autowired
	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
		this.issueHistoryRepository = issueHistoryRepository;
	}
	
	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		if(issueHistory.getDate() == null) {
			throw new IllegalArgumentException("issue history can not be null");
		}
		return issueHistoryRepository.save(issueHistory);
	}

	@Override
	public IssueHistory getById(Long id) {
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {
		issueHistoryRepository.delete(issueHistory);
		return Boolean.TRUE;
	}

}
