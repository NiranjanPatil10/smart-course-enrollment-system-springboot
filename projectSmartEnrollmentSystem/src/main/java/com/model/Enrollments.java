package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "enrollments")
public class Enrollments {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "ID")
	private int enrollmentId;
	
	 @Column(name = "Student_Id")
	private int studentId;
	
	 @Column(name = "Course_Id")
	private int courseId;
	
	 @Column(name = "status")
	private String status;

	 
	 
	 public Enrollments() {
		super();
	 }



	 public Enrollments(int enrollmentId, int studentId, int courseId, String status) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.status = status;
	 }



	 public int getEnrollmentId() {
		 return enrollmentId;
	 }



	 public void setEnrollmentId(int enrollmentId) {
		 this.enrollmentId = enrollmentId;
	 }



	 public int getStudentId() {
		 return studentId;
	 }



	 public void setStudentId(int studentId) {
		 this.studentId = studentId;
	 }



	 public int getCourseId() {
		 return courseId;
	 }



	 public void setCourseId(int courseId) {
		 this.courseId = courseId;
	 }



	 public String getStatus() {
		 return status;
	 }



	 public void setStatus(String status) {
		 this.status = status;
	 }
	 
	 
	 
	 
	
	

}
