package com.example.StudentManagementSystem.services;

import org.springframework.stereotype.Service;
import com.example.StudentManagementSystem.model.StudentManagementSystem;

@Service 
public class StudentManagementSystemservices {
    public StudentManagementSystem getStudent() {
        // Logic to retrieve a student from the database
        return new StudentManagementSystem("John Doe", "john.doe@example.com","Computer Science", 20);
}
     public StudentManagementSystem createStudent(StudentManagementSystem student) {
        // Logic to create a new student in the database
        return student;
     }
    }