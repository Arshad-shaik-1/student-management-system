package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.dto.request.StudentRequestDTO;
import com.Arshad.StudentManagementSystem.dto.response.StudentResponseDTO;
import com.Arshad.StudentManagementSystem.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponseDTO addStudent(StudentRequestDTO request);

    List<Student> getStudents();

    Student getStudent(Long id );

    Student updateStudent(Long id ,Student student);

    Student deleteStudent(Long id);
}
