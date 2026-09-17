package com.example.StudentManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentManagementSystem.services.StudentManagementSystemservices;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.StudentManagementSystem.model.StudentManagementSystem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/students")
public class StudentManagementSystemcontrollers {
    private final StudentManagementSystemservices services;

    public StudentManagementSystemcontrollers(StudentManagementSystemservices services) {
        this.services = services;
    }
    @GetMapping
    public StudentManagementSystem getStudentB() {
        return services.getStudent();
    }
    @PostMapping
    public StudentManagementSystem createStudent(@RequestBody StudentManagementSystem student) {
        return services.createStudent(student);
    }
    

}
