package com.wipro.rolebasedjwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.rolebasedjwt.model.DAOUser;
import com.wipro.rolebasedjwt.model.UserDTO;
import com.wipro.rolebasedjwt.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DAOUser user = userRepository.findByUsername(username);		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getUsername(), user.getPassword(),authorities);
	}

	public DAOUser registerUser(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setUsername(user.getUsername());
		newUser.setPhone(user.getPhone());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole("ROLE_USER");
		return userRepository.save(newUser);
	}
	
	public List<DAOUser> getAllUser(){
		return userRepository.findAll();
	}
	
	public DAOUser getUser(String username) {
		DAOUser user = userRepository.findByUsername(username);	
		return user;
	}
	
	public DAOUser updateUser(UserDTO user, String username) {
		DAOUser updateUser = userRepository.findByUsername(username);
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setEmail(user.getEmail());
		updateUser.setUsername(user.getUsername());
		updateUser.setPhone(user.getPhone());
		updateUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		updateUser.setRole(updateUser.getRole());
		return userRepository.save(updateUser);
	}
	
	public DAOUser deleteUser(String username) {
		DAOUser user = getUser(username);
		userRepository.delete(user);
		return user;
	}
}
