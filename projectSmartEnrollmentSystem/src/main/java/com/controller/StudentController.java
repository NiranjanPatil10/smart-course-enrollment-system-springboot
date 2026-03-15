package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.StudentDTO;
import com.model.Student;
import com.service.StudentService;


@RestController

public class StudentController {
	
	
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/register")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody Student s) {

	    Student student = studentService.registerStudent(s);

	    StudentDTO dto = new StudentDTO(
	            student.getId(),
	            student.getName(),
	            student.getEmail(),
	            student.getTotalCredits()  );

	    return ResponseEntity.ok(dto);
	}


	
	
	@PostMapping("/login")
	 public ResponseEntity<?> login(@RequestBody Student s){
		
		
		try {
		
		Student student = studentService.loginStudent(s.getEmail(),s.getPassword());
		
		
		StudentDTO dto = new StudentDTO(
		  student.getId(),
		  student.getName(),
		  student.getEmail(),
		  student.getTotalCredits() );
		
		
		return ResponseEntity.ok(dto);
		
	}catch (RuntimeException e) {
		
		
		if(e.getMessage().equals("Email Not Found")) {
			return ResponseEntity.status(404).body("Email Not Found");
			
		}
		
		if(e.getMessage().equals("Invalid password")) {
			return ResponseEntity.status(401).body("Invalid password");
	}
		
		return ResponseEntity.status(500).body("Something went Wrong");
		
	}
	}
}
	
	
	
	

