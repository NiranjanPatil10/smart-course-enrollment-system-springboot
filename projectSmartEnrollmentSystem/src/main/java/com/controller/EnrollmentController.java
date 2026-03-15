package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.model.Enrollments;
import com.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	
	
	
	@Autowired
	private EnrollmentService enService;
	
	
	
	
	@PostMapping("/enroll")
	public ResponseEntity<?> enrollStudent(@RequestParam Integer studentId, @RequestParam Integer courseId){
		
		
		
		 try {
		
		Enrollments enrollment = enService.enrollStudents(studentId, courseId);
		
		return ResponseEntity.ok(enrollment);
		
		
		  } catch (RuntimeException e) {

		
		return ResponseEntity.badRequest().body(e.getMessage());
	}

		 
		 
}
}