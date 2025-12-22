package com.paramkansagra.StudentManagement.service.ServiceImpl;

import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.entity.Student;
import com.paramkansagra.StudentManagement.repository.StudentRepository;
import com.paramkansagra.StudentManagement.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentByID(Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException("Student with " + id + " not found");
        }

        Student student = optionalStudent.get();

        return new StudentDTO(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> studentList = studentRepository.findAll();

        return studentList
                .stream()
                .map(
                        (student) -> new StudentDTO(
                                student.getId(),
                                student.getName(),
                                student.getEmail()
                        )
                ).toList();
    }
}
