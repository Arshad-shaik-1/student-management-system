package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student s);

    List<Student> getStudents();

    Optional<Student> getStudent(Long id);
}
