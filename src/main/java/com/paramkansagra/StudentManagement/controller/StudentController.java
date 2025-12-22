package com.paramkansagra.StudentManagement.controller;

import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/students")
    public StudentDTO getStudents(){
        return new StudentDTO(1L , "Param Kansagra" , "someRandomEmail@gmail.com");
    }

    @GetMapping("/students/{id}")
    public String getStudentByID(@PathVariable Long id){
        return "Getting student with id -> " + id;
    }
}
