package com.Arshad.StudentManagementSystem.controller;

import com.Arshad.StudentManagementSystem.dto.request.StudentRequestDTO;
import com.Arshad.StudentManagementSystem.dto.response.StudentResponseDTO;
import com.Arshad.StudentManagementSystem.entity.Student;
import com.Arshad.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(
            @Valid @RequestBody StudentRequestDTO request){
        StudentResponseDTO response = service.addStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


//    @GetMapping
//    public List<StudentResponseDTO> getStudents(){
//        return service.getStudents();
//    }


    @GetMapping("/{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent( @PathVariable Long id , @Valid @RequestBody StudentRequestDTO student){
        return service.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public StudentResponseDTO deleteStudent(@PathVariable Long id){
        return service.deleteStudent(id);
    }

    @GetMapping()
    public Page<Student> getStudents(@RequestParam(defaultValue = "0") int page ,
                                     @RequestParam(defaultValue = "10") int size ,
                                     @RequestParam(defaultValue = "id") String sortBy){
        return service.getStudents(page , size , sortBy);
    }

    @GetMapping("/search/name")
    public Page<Student> searchByName(@RequestParam String name , @RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        return service.searchByName(name , page , size);
    }

    @GetMapping("/search/age")
    public Page<Student> searchByAge(@RequestParam int age , @RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        return service.searchByAge(age , page , size);
    }

    @GetMapping("/search/department")
    public Page<Student> searchByDept(@RequestParam String dept , @RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        return service.searchByDept(dept, page , size);
    }

    @GetMapping("/search/Email")
    public Page<Student> searchByEmail(@RequestParam String email , @RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){

        return service.searchByEmail(email , page , size);
    }

}
