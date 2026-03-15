# Smart Course Enrollment System

A **Spring Boot based RESTful backend application** designed to manage student course registration and enrollment efficiently.  
The system allows students to register, log in, explore available courses, and enroll in them while enforcing important business rules such as seat limits, duplicate enrollment prevention, and automatic credit calculation.

This project demonstrates a **clean layered architecture using Spring Boot, Spring Data JPA, and MySQL**, following industry-standard backend development practices.

---

## 🚀 Key Features

- Student Registration and Login
- Course Management (Add & View Courses)
- Student Course Enrollment
- Duplicate Enrollment Prevention
- Course Seat Limit Validation
- Automatic Student Credit Calculation
- DTO-based API Responses
- Custom Exception Handling
- Clean Layered Architecture

---

## 🏗️ Project Architecture

This project follows a **layered backend architecture using Spring Boot**:

Controller → Service → Repository → Database

- **Controller Layer**  
Handles REST API requests and responses.

- **Service Layer**  
Contains core business logic such as validation rules, enrollment restrictions, and credit calculations.

- **Repository Layer**  
Uses **Spring Data JPA** for database operations.

- **DTO Layer**  
Ensures secure and structured API responses by avoiding exposure of sensitive fields.

---

## 🗄️ Database Design

The system is built on a relational database with the following core entities:

### Student
- id
- name
- email
- password
- totalCredits

### Course
- id
- courseName
- credits
- maxSeats

### Enrollment
- id
- studentId
- courseId
- status

Relationships:

- A **student can enroll in multiple courses**
- A **course can have multiple students**

---

## ⚙️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- Maven

---

## 📌 Business Logic Implemented

The application enforces several important backend validations:

- A student **cannot enroll in the same course twice**
- Course enrollment is **restricted by maximum seat availability**
- Student **credits are automatically updated** after successful enrollment
- Duplicate student registrations are prevented using **email validation**

---

## 🔗 Example API Endpoints

### Student APIs

POST /students/register  
POST /students/login  

### Course APIs

POST /courses  
GET /courses  
GET /courses/{id}

### Enrollment APIs

POST /enrollments/enroll?studentId=1&courseId=2

---

## 📊 Project Highlights

- Designed with **clean code practices**
- Implements **real-world backend validation logic**
- Uses **Spring Data JPA for efficient database interaction**
- Follows **industry-style layered architecture**

---

## 🎯 Future Enhancements

- Admin dashboard for managing courses
- JWT-based authentication
- Course prerequisite validation
- API documentation using Swagger
- Frontend integration (React)

---

## 👨‍💻 Author

**Niranjan Patil**

Java Backend Developer | Spring Boot | REST API Development
