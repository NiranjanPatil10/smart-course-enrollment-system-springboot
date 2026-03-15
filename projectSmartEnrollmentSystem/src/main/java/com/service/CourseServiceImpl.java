package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CourseRepository;
import com.exception.DuplicateResourceException;
import com.exception.ResourceNotFoundException;
import com.model.Course;


@Service
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	private CourseRepository courseRepo;

	
	
	@Override
	public Course addCourse(Course course) {
		
		
		  Course existingCourse = courseRepo.findByCourseName(course.getCourseName());

		    if(existingCourse != null){
		        throw new DuplicateResourceException("Course already exists");
		    }

	
		return courseRepo.save(course);
	}
	
	
	

	@Override
	public List<Course> getAllCourses() {
	
		return courseRepo.findAll();
	}
	
	

	@Override
	public Course getCourseById(Integer id) {
	
		  return courseRepo.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
	}
	
	
}