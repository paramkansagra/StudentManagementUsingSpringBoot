package com.paramkansagra.StudentManagement.controller;

import com.paramkansagra.StudentManagement.dto.AddStudentRequestDTO;
import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put is used for changing most of the things of the user
    @PutMapping("/{id}")
    // Because we don't want to accept userid in the dto we will resue the AddStudentRequestDTO
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id , @RequestBody AddStudentRequestDTO updateStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(id , updateStudentRequestDTO));
    }

    // Patch is used for changing only 1 value of the user
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> patchStudent(@PathVariable Long id , @RequestBody Map<Object , Object> updates){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updatePartialStudent(id , updates));
    }
}
