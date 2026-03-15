package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentRepository;
import com.exception.DuplicateResourceException;
import com.exception.ResourceNotFoundException;
import com.model.Student;


@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepository studentRepo;
	

	@Override
	public Student registerStudent(Student s) {
		
		
		Student student = studentRepo.findByEmail(s.getEmail());
		
		
		 if (student != null) {
	            throw new DuplicateResourceException("Email already registered");
	        }
		 
		 

	        s.setTotalCredits(0);

	        return studentRepo.save(s);
	    }

	    @Override
	    public Student loginStudent(String email, String password) {

	        Student student = studentRepo.findByEmail(email);

	        if (student == null) {
	            throw new ResourceNotFoundException("Email not found");
	        }
	        
	        

	        if (!student.getPassword().equals(password)) {
	            throw new ResourceNotFoundException("Invalid password");
	        }
	        
	        
	        

	        return student;
	    }

	    @Override
	    public Student getStudentById(Integer id) {

	        return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
	    }
	    
	    
	    

	    @Override
	    public List<Student> getAllStudents() {

	        return studentRepo.findAll();
	    }

	}