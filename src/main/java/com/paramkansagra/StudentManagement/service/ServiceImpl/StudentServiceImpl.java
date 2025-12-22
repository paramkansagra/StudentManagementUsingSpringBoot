package com.paramkansagra.StudentManagement.service.ServiceImpl;

import com.paramkansagra.StudentManagement.dto.AddStudentRequestDTO;
import com.paramkansagra.StudentManagement.dto.StudentDTO;
import com.paramkansagra.StudentManagement.entity.Student;
import com.paramkansagra.StudentManagement.repository.StudentRepository;
import com.paramkansagra.StudentManagement.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO getStudentByID(Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException("Student with " + id + " not found");
        }

        Student student = optionalStudent.get();

        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> studentList = studentRepository.findAll();

        return studentList.stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
        Student student = modelMapper.map(addStudentRequestDTO, Student.class);

        Student newStudent = studentRepository.save(student);

        return modelMapper.map(newStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDTO updateStudentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException("Student with id " + id + " not present");
        }

        Student student = optionalStudent.get();

        modelMapper.map(updateStudentDTO, student);
        student = studentRepository.save(student);

        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<Object, Object> updates) {
        final Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));

        updates.forEach((field, value) ->
                {
                    switch (field.toString()) {
                        case "name":
                            student.setName(value.toString());
                            break;
                        case "email":
                            student.setEmail(value.toString());
                            break;
                        default:
                            throw new IllegalArgumentException("Field is not supported");
                    }
                }
        );

        Student savedStudent = studentRepository.save(student);

        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with " + id + " not found");
        }

        studentRepository.deleteById(id);
    }
}
