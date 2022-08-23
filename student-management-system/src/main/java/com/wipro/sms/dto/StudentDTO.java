package com.wipro.sms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private long id;
	private String uname;
	private String password;
	private LocalDate dob;
	private String gender;
	private String email;
	private long phone;
	private String course;
	private String status;
}
