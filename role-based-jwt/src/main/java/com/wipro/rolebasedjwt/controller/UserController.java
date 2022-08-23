package com.wipro.rolebasedjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rolebasedjwt.model.DAOUser;
import com.wipro.rolebasedjwt.model.UserDTO;
import com.wipro.rolebasedjwt.service.CustomUserDetailsService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@GetMapping("/getall")
	public List<DAOUser> getAllUser(){
		return customUserDetailsService.getAllUser();
	}
	
	@GetMapping("/get/{username}")
	public DAOUser getuser(@PathVariable String username) {
		return customUserDetailsService.getUser(username);
	}
	
	@PutMapping("/update/{username}")
	public DAOUser updateUser(@RequestBody UserDTO user,@PathVariable String username) {
		return customUserDetailsService.updateUser(user, username);
	}
	
	@DeleteMapping("/delete/{username}")
	public DAOUser deleteUser(@PathVariable String username) {
		DAOUser user = customUserDetailsService.deleteUser(username);
		return user;
	}
	
}
