package com.paramkansagra.StudentManagement.repository;

import com.paramkansagra.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository is the place where we will be writing our queries, and it would do calls to the db
// for clear separation between all the layers

// we are implementing this repository for Student and the ID type is long
public interface StudentRepository extends JpaRepository<Student, Long> {
}
