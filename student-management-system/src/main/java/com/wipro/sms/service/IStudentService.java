package com.wipro.sms.service;

import java.util.List;

import com.wipro.sms.dto.StudentDTO;
import com.wipro.sms.entity.Student;

public interface IStudentService {
	
	public List<Student> getAllStudent();
	
	public Student saveStudent(StudentDTO dto);
	
	public Student getStudentById(long id);
	
	public Student updateStudent(StudentDTO dto, long id);
	
	public void deleteStudent(long id);
	
}
