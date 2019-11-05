package com.yilberk.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yilberk.domain.User;

public interface UserService {
	
	User save(User user);
	
	User getById(Long id);
	
	Page<User> getAllPageable(Pageable pageable);
	
	User getByUserName(String userName);

}
