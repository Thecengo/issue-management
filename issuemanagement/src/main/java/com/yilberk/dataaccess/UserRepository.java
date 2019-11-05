package com.yilberk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilberk.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
