package com.Arshad.StudentManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Students")
public class Student {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 16 , message = "Age must be above 15")
    private int age ;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Department cannot be null")
    private String department;

    public Student(){}
    public Student(String name,  int age, String email, String department) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
