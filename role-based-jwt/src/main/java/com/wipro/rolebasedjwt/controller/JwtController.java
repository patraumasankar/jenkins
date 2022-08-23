package com.wipro.rolebasedjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rolebasedjwt.model.DAOUser;
import com.wipro.rolebasedjwt.model.JwtRequest;
import com.wipro.rolebasedjwt.model.JwtResponse;
import com.wipro.rolebasedjwt.model.UserDTO;
import com.wipro.rolebasedjwt.repository.UserRepository;
import com.wipro.rolebasedjwt.service.CustomUserDetailsService;
import com.wipro.rolebasedjwt.util.JwtUtil;



@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);
		DAOUser user = this.userRepository.findByUsername(jwtRequest.getUsername());
		System.out.println("JWT " + token);
		return ResponseEntity.ok(new JwtResponse(user,token));

	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(customUserDetailsService.registerUser(user));
	}
	
	@GetMapping("/token/{token}")
	public ResponseEntity<DAOUser> getUser(@PathVariable String token) {
		String username= this.jwtUtil.getUsernameFromToken(token);
		DAOUser user = this.userRepository.findByUsername(username);
		return new ResponseEntity<DAOUser>(user, HttpStatus.OK);
	}
	
}
