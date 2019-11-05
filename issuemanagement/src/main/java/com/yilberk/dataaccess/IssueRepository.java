package com.yilberk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilberk.domain.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
