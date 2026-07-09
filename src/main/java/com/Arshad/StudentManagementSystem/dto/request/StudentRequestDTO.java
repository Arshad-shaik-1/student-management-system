package com.Arshad.StudentManagementSystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDTO {

    public StudentRequestDTO(String name, String email, int age, String department) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
    }
    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Department should not be blank")
    private String department;

    @Min(value = 16 , message = "Age must be 16 years")
    private int age;

    public StudentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
