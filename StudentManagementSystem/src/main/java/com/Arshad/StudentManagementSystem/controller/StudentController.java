package com.Arshad.StudentManagementSystem.controller;

import com.Arshad.StudentManagementSystem.entity.Student;
import com.Arshad.StudentManagementSystem.repository.StudentRepository;
import com.Arshad.StudentManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @PostMapping
    public Student addStudent(@RequestBody Student s){
        System.out.println("Post in controller");
       return  service.addStudent(s);
    }
    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }
}
