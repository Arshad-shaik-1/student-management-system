package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student s);

    List<Student> getStudents();
}
