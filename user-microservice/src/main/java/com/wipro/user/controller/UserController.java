package com.wipro.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.user.dto.UserDTO;
import com.wipro.user.entity.User;
import com.wipro.user.service.IUserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User addUser(@RequestBody UserDTO userDTO) {
		return service.addUser(userDTO);
	}
	
	@GetMapping("/get/{uid}")
	public User getUserById(@PathVariable("uid") long uid) {
		return service.getUserById(uid);
	}
	
}
