package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "courses")
public class Course {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Course_Name")
    private String courseName;

    @Column(name = "credits")
    private int credits;

    @Column(name = "Max_seats")
    private int maxSeats;

    
    
	public Course() {
		super();
	}



	public Course(int id, String courseName, int credits, int maxSeats) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.credits = credits;
		this.maxSeats = maxSeats;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public int getCredits() {
		return credits;
	}



	public void setCredits(int credits) {
		this.credits = credits;
	}



	public int getMaxSeats() {
		return maxSeats;
	}



	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
    
    
    
	
    
    
}
