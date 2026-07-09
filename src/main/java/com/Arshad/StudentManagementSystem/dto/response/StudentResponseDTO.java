package com.Arshad.StudentManagementSystem.dto.response;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private int age;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, int age, String department, String email, String name) {
        this.id = id;
        this.age = age;
        this.department = department;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
