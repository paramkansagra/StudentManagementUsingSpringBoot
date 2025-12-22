package com.paramkansagra.StudentManagement.service;

import com.paramkansagra.StudentManagement.dto.AddStudentRequestDTO;
import com.paramkansagra.StudentManagement.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentDTO getStudentByID(Long id);

    List<StudentDTO> getStudents();

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updateStudent(Long id, AddStudentRequestDTO updateStudentDTO);

    StudentDTO updatePartialStudent(Long id , Map<Object , Object> updates);

    void deleteStudentById(Long id);

}
