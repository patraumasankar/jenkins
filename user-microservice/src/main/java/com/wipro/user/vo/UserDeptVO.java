package com.wipro.user.vo;

import com.wipro.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDeptVO {
	
	private User user;
	private Department department;
	
}
