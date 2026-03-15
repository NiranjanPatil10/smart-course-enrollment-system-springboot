package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CourseRepository;
import com.dao.EnrollmentRepository;
import com.dao.StudentRepository;
import com.exception.DuplicateResourceException;
import com.exception.ResourceNotFoundException;
import com.model.Enrollments;
import com.model.Student;
import com.model.Course;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	
	
	@Autowired
	private EnrollmentRepository enrollmentRepo;

	
	

	@Autowired
	private StudentRepository studentRepo;
	
	

	@Autowired
	private CourseRepository courseRepo;
	
	
	
	
	
	@Override
	public Enrollments enrollStudents(Integer studentId, Integer courseId) {
	
		
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
		
		
		
		
		Course course = courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
		
		
		
		
		
		
		
		  
            
            
            // Duplicate enrollment checking by studentId and courseId
            
            if(enrollmentRepo.existsByStudentIdAndCourseId(studentId, courseId)) {
            	
            	throw new DuplicateResourceException("Student already enrolled in this course");
            }
            
            
            
            // Course seat availability checking by courseId
            
            long count = enrollmentRepo.countByCourseId(courseId);
            
            if(count>= course.getMaxSeats()) {
            	
            	throw new DuplicateResourceException("Course is full");
            }
            
            
            
            
            // credit updating
            
            int newCredits = student.getTotalCredits() + course.getCredits();
            student.setTotalCredits(newCredits);
            studentRepo.save(student);
            
            
            
            
            
            
            Enrollments enrollment = new Enrollments();
            
            
            enrollment.setStudentId(studentId);
            enrollment.setCourseId(courseId);
            enrollment.setStatus("Enrolled");
            
            
		
		return enrollmentRepo.save(enrollment);
	}
	
	

}
