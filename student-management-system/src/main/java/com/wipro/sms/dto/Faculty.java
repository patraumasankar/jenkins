package com.wipro.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	
	private long id;
    private String name;
    private String course;
    private double salary;
    
}
