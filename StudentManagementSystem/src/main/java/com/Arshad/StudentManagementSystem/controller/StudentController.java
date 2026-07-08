package com.Arshad.StudentManagementSystem.controller;

import com.Arshad.StudentManagementSystem.dto.request.StudentRequestDTO;
import com.Arshad.StudentManagementSystem.dto.response.StudentResponseDTO;
import com.Arshad.StudentManagementSystem.entity.Student;
import com.Arshad.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(
            @Valid @RequestBody StudentRequestDTO request){
        StudentResponseDTO response = service.addStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent( @PathVariable Long id , @Valid @RequestBody Student student){
        return service.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Long id){
        return service.deleteStudent(id);
    }
}
