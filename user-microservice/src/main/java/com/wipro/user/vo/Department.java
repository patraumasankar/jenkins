package com.wipro.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
	
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
