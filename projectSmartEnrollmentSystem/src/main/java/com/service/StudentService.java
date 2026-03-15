package com.service;

import java.util.List;

import com.model.Student;


public interface StudentService {
	
	
	public Student registerStudent(Student student);
	
	public Student loginStudent(String email, String password);
	
	public Student getStudentById(Integer id);
	
	List<Student> getAllStudents();

}
