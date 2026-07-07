package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.Exception.StudentNotFoundException;
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
    public Student getStudent(Long id){
        return repo.findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException("No Student found with id "+id));
    }

    @Override
    public Student updateStudent(Long id , Student student){
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setEmail(student.getEmail());
        existing.setDepartment(student.getDepartment());
        return repo.save(existing);
    }
    @Override
    public Student deleteStudent(Long id){
        Student del = repo.findById(id).orElseThrow();
        repo.deleteById(id);
        return del;
    }

}
