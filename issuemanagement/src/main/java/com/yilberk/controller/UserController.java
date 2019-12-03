package com.yilberk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilberk.dto.UserDto;
import com.yilberk.service.UserService;
import com.yilberk.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.UserControllerPath.path)
@Api(value = ApiPaths.UserControllerPath.path, description = "User APIs")
@CrossOrigin
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<UserDto> getUsersByUserName(@PathVariable String userName) {
		UserDto userDto = userService.getByUserName(userName);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping()
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> usersList = userService.getAll();
		return ResponseEntity.ok(usersList);	
	}
	
	
	@PostMapping("/")
	@ApiOperation(value = "Create Operation", response = UserDto.class)
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto userCreated = userService.save(userDto);
		return ResponseEntity.ok(userCreated);	
	}

}
