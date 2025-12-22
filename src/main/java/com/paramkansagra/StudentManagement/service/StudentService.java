package com.paramkansagra.StudentManagement.service;

import com.paramkansagra.StudentManagement.dto.AddStudentRequestDTO;
import com.paramkansagra.StudentManagement.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public StudentDTO getStudentByID(Long id);

    public List<StudentDTO> getStudents();

    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    public void deleteStudentById(Long id);
}
