package com.wipro.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wipro.user.dto.UserDTO;
import com.wipro.user.entity.User;
import com.wipro.user.repository.UserRepository;
import com.wipro.user.vo.Department;
import com.wipro.user.vo.UserDeptVO;

public class UserServiceImp implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User addUser(UserDTO userDTO) {
		
		User user = new User();
		
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setDepartmentId(userDTO.getDepartmentId());
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long uid) {
		return userRepository.findById(uid).orElse(new User());
	}

	@Override
	public UserDeptVO getUserByIdWithDepartment(long uid) {
		
		User user = getUserById(uid);
		
		long deptId = user.getDepartmentId();
		
		
		ResponseEntity<Department> response = restTemplate.getForEntity(null, Department.class);
		
		Department department = response.getBody();
		
		UserDeptVO userDept = new UserDeptVO(user,department);
		
		return userDept;
		
	}

}
