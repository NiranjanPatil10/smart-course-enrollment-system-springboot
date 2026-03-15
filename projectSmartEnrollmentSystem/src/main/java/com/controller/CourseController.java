package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Course;
import com.service.CourseService;


@RestController
@RequestMapping("/courses")
public class CourseController {
	
	
	@Autowired
	private CourseService service;
	
	
	
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
    	
    	
    	Course savedcourse = service.addCourse(course);
    	
    	
    	return ResponseEntity.ok(savedcourse);
    }
    
    
    
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
    	
    	
    	
    	List<Course> courses = service.getAllCourses();    
    	
    	
    	return ResponseEntity.ok(courses);
    }
    
	
	
	@GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
		
		
		Course course = service.getCourseById(id);
		
		
		 if (course == null) {
	            return ResponseEntity.notFound().build();
	        }

		
		
		return ResponseEntity.ok(course);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
