package com.wipro.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.sms.dto.StudentDTO;
import com.wipro.sms.entity.Student;
import com.wipro.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(StudentDTO dto) {
		
		Student student = new Student();
		
		student.setUname(dto.getUname());
		student.setPassword(dto.getPassword());
		student.setDob(dto.getDob());
		student.setGender(dto.getGender());
		student.setEmail(dto.getEmail());
		student.setPhone(dto.getPhone());
		student.setCourse(dto.getCourse());
		student.setStatus("pending");
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(new Student());
	}

	@Override
	public Student updateStudent(StudentDTO dto, long id) {
		
		Student updateStudent = getStudentById(id);
		
		updateStudent.setUname(dto.getUname());
		updateStudent.setPassword(dto.getPassword());
		updateStudent.setDob(dto.getDob());
		updateStudent.setGender(dto.getGender());
		updateStudent.setEmail(dto.getEmail());
		updateStudent.setPhone(dto.getPhone());
		updateStudent.setCourse(dto.getCourse());
		updateStudent.setStatus(dto.getStatus());
		
		return studentRepository.save(updateStudent);
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);		
	}

}
