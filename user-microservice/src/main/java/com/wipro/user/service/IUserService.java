package com.wipro.user.service;

import com.wipro.user.dto.UserDTO;
import com.wipro.user.entity.User;
import com.wipro.user.vo.UserDeptVO;

public interface IUserService {
	
	public User addUser(UserDTO userDTO);
	
	public User getUserById(long uid);
	
	public UserDeptVO getUserByIdWithDepartment(long uid);
}
