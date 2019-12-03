package com.yilberk.service.impl;


import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yilberk.dataaccess.UserRepository;
import com.yilberk.domain.User;
import com.yilberk.dto.UserDto;
import com.yilberk.service.UserService;
import com.yilberk.util.TPage;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public UserDto save(UserDto userDto) {
		User userEmailCheck = userRepository.getOne(userDto.getId());
		if(userEmailCheck.getEmail() == null) {
			throw new IllegalArgumentException("e mail can not be null");
		}
		User saveUser = modelMapper.map(userDto,User.class);
		saveUser = userRepository.save(saveUser);
		userDto.setId(saveUser.getId());
		
		return userDto;
	}

	@Override
	public UserDto getById(Long id) {
		User userMapper = userRepository.getOne(id);
		return modelMapper.map(userMapper, UserDto.class);
	}

	@Override
	public TPage<UserDto> getAllPageable(Pageable pageable) {
		Page<User> getAllPage = userRepository.findAll(pageable);
		TPage<UserDto> responsePage = new TPage<>();
		List<UserDto> mapperList = Arrays.asList(modelMapper.map(getAllPage.getContent(),UserDto[].class));
		responsePage.setStat(getAllPage, mapperList );
		return responsePage;
	}
	
	@Override
	public List<UserDto> getAll() {
		List<User> getAllPage = userRepository.findAll();
		List<UserDto> mapperList = Arrays.asList(modelMapper.map(getAllPage,UserDto[].class));
		
		return mapperList;
	}

	@Override
	public UserDto getByUserName(String userName) {
		User getUserByName = userRepository.findByUsername(userName);
		UserDto mappedUser = modelMapper.map(getUserByName, UserDto.class);
		return mappedUser;
	}
	

}
