package com.yilberk.service;


import java.util.List;

import org.springframework.data.domain.Pageable;
import com.yilberk.dto.UserDto;
import com.yilberk.util.TPage;

public interface UserService {
	
	UserDto save(UserDto userDto);
	
	UserDto getById(Long id);
	
	TPage<UserDto> getAllPageable(Pageable pageable);
	
	UserDto getByUserName(String userName);
	
	List<UserDto> getAll();

}
