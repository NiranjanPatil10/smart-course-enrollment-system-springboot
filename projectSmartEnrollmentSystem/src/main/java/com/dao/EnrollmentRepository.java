package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Enrollments;



public interface EnrollmentRepository extends JpaRepository<Enrollments, Integer> {
	
	boolean existsByStudentIdAndCourseId(Integer studentId, Integer courseId);
	
	long countByCourseId(Integer courseId);
	
	

}
