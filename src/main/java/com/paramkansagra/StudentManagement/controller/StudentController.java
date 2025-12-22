package com.paramkansagra.StudentManagement.controller;

import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudentByID(@PathVariable Long id) {
        return studentService.getStudentByID(id);
    }
}
