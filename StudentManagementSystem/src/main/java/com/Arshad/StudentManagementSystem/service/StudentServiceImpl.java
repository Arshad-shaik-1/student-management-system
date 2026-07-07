package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.entity.Student;
import com.Arshad.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;
    public StudentServiceImpl(StudentRepository repo){
        this.repo = repo;
    }

    @Override
    public Student addStudent(Student s) {
        System.out.println("post in service impl");
        return repo.save(s);
    }
    @Override
    public List<Student> getStudents(){
     return repo.findAll();
    }
    @Override
    public Optional<Student> getStudent(Long id){
        return repo.findById(id);
    }
}
