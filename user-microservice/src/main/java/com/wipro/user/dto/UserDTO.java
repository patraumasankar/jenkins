package com.wipro.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	
	private long userId;
	private String userName;
	private String email;
	private long departmentId;
	
}
