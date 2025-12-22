package com.paramkansagra.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This will create getter and setters for the dto and also constructors for the same
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDTO {
    private String name;
    private String email;
}
