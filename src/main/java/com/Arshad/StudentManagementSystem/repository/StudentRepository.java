package com.Arshad.StudentManagementSystem.repository;

import com.Arshad.StudentManagementSystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
    Page<Student> findByName(String name , Pageable p);
    Page<Student> findByAge(int age , Pageable p);
    Page<Student> findByDepartment(String dept , Pageable p);
    Page<Student> findByEmail(String email , Pageable p);

}
