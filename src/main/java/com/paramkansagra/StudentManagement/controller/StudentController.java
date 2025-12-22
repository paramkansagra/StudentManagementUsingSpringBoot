package com.paramkansagra.StudentManagement.controller;

import com.paramkansagra.StudentManagement.dto.AddStudentRequestDTO;
import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
