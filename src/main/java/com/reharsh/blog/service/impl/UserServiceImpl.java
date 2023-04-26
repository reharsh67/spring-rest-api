package com.reharsh.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reharsh.blog.dto.UserDto;
import com.reharsh.blog.entity.User;
import com.reharsh.blog.repository.UserRepo;
import com.reharsh.blog.service.UserService;
import com.reharsh.blog.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;

	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		user = this.userRepo.save(user);
		return this.userToDto(user);
	}

	public UserDto updateUser(UserDto userDto, Integer id) {

		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		user = this.userRepo.save(user);
		return this.userToDto(user);
	}

	public UserDto getUserById(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return this.userToDto(user);
	}

	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	public void deleteUser(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		this.userRepo.delete(user);
	}

	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		return user;

	}

	private UserDto userToDto(User user) {
		UserDto userDto1 = new UserDto();
		userDto1.setId(user.getId());
		userDto1.setAbout(user.getAbout());
		userDto1.setEmail(user.getEmail());
		userDto1.setName(user.getName());
		userDto1.setPassword(user.getPassword());

		return userDto1;

	}

}
