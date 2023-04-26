package com.reharsh.blog.service;

import java.util.List;

import com.reharsh.blog.dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto user);
	public UserDto updateUser(UserDto user, Integer id);
	public UserDto getUserById(Integer id);
	public List<UserDto> getAllUsers();
	public void deleteUser(Integer id);

}
