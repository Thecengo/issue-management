package com.yilberk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilberk.domain.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long>{

}
