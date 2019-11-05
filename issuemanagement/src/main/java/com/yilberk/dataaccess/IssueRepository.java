package com.yilberk.dataaccess;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yilberk.domain.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long>{

//	Issue getByProjectCode(String projectCode);
	
//	Issue getByProjectCodeAndIdNot(String projectCode, Long id);
	
//	List<Issue> getByProjectCodeContains(String project);
	
	Page<Issue> findAll(Pageable pageable);
	
	List<Issue> findAll(Sort sort);
	
	void deleteById(Long id);
}
