package com.service;

import com.model.Enrollments;


public interface EnrollmentService {
	
	Enrollments enrollStudents (Integer studentId, Integer courseId);

}
