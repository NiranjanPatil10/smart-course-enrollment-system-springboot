package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	
	
	Course findByCourseName(String courseName);
	
}
