package com.wipro.sms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.sms.dto.Faculty;
import com.wipro.sms.dto.StudentDTO;
import com.wipro.sms.entity.Student;
import com.wipro.sms.service.IStudentService;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getall")
	public List<Student> getAllStudent() {
		return service.getAllStudent();
	}
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody StudentDTO dto) {
		return service.saveStudent(dto);
	}
	
	@GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable long id) {
        try {
            Student student = service.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody StudentDTO student, @PathVariable long id) {
		try {
			Student updateStudent = service.updateStudent(student, id);
			return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
    	 try {
             service.deleteStudent(id);
             return new ResponseEntity<>(HttpStatus.OK);

         } catch (NoSuchElementException e) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
    
    @GetMapping("/faculty/getall")
    public List<Faculty> getAllFaculty(){
    	
    	ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8181/api/v1/faculty/getall", List.class);
    	
    	List<Faculty> list = response.getBody();
    	
    	return list;
    }
    
    @PostMapping("/add/faculty")
    public Faculty saveFaculty(@RequestBody Faculty faculty) {
    	ResponseEntity<Faculty> response = restTemplate.postForEntity("http://localhost:8181/api/v1/faculty/save", faculty, Faculty.class);
    	return response.getBody();
    }
}
