package com.service;

import java.util.List;

import com.model.Course;

public interface CourseService {
	
	
	Course addCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getCourseById(Integer id);

}
