package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.dto.request.StudentRequestDTO;
import com.Arshad.StudentManagementSystem.dto.response.StudentResponseDTO;
import com.Arshad.StudentManagementSystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponseDTO addStudent(StudentRequestDTO request);

    List<StudentResponseDTO> getStudents();

    StudentResponseDTO getStudent(Long id );

    StudentResponseDTO updateStudent(Long id , StudentRequestDTO student);

    StudentResponseDTO deleteStudent(Long id);

    Page<Student> getStudents(int page , int size , String sortBy);
}
