package com.Arshad.StudentManagementSystem.service;

import com.Arshad.StudentManagementSystem.Exception.StudentNotFoundException;
import com.Arshad.StudentManagementSystem.dto.request.StudentRequestDTO;
import com.Arshad.StudentManagementSystem.dto.response.StudentResponseDTO;
import com.Arshad.StudentManagementSystem.entity.Student;
import com.Arshad.StudentManagementSystem.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.util.List;

@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;
    public StudentServiceImpl(StudentRepository repo){
        this.repo = repo;
    }

    @Override
    public StudentResponseDTO addStudent(StudentRequestDTO request) {
        System.out.println("post in service impl");
        Student student = new Student();
        student.setName(request.getName());
        student.setDepartment(request.getDepartment());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());

        Student saved = repo.save(student);

        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(saved.getId());
        response.setAge(saved.getAge());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setDepartment(saved.getDepartment());

        return response;
    }
    @Override
    public List<StudentResponseDTO> getStudents(){
        List<Student> list = repo.findAll();
        return list.stream()
                .map( s ->{
                    StudentResponseDTO dto = new StudentResponseDTO();
                    dto.setName(s.getName());
                    dto.setDepartment(s.getDepartment());
                    dto.setAge(s.getAge());
                    dto.setEmail(s.getEmail());
                    dto.setId(s.getId());
                    return dto;
                }).toList();
    }
    @Override
    public StudentResponseDTO getStudent(Long id){
        Student s = repo.findById(id).orElseThrow( () ->  new StudentNotFoundException("Student not found"));
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(s.getId());
        response.setName(s.getName());
        response.setAge(s.getAge());
        response.setEmail(s.getEmail());
        response.setDepartment(s.getDepartment());
        return response;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id , StudentRequestDTO student){
        Student existing = repo.findById(id).orElseThrow( () -> new StudentNotFoundException("No student found to update with id "+id));
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setEmail(student.getEmail());
        existing.setDepartment(student.getDepartment());
        Student saved = repo.save(existing);
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(saved.getId());
        response.setAge(saved.getAge());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setDepartment(saved.getDepartment());
        return response;
    }
    @Override
    public StudentResponseDTO deleteStudent(Long id){
        Student del = repo.findById(id).orElseThrow( () -> new StudentNotFoundException("No student found with id" +id +" to delete."));
        repo.deleteById(id);
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(del.getId());
        response.setName(del.getName());
        response.setAge(del.getAge());
        response.setDepartment(del.getDepartment());
        response.setEmail(del.getEmail());
        return response;
    }

    @Override
    public Page<Student> getStudents(int page , int size , String sortBy){
        Pageable p = PageRequest.of(page , size , Sort.by(sortBy));
        return repo.findAll(p);
    }
}
