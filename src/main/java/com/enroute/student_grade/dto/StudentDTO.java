package com.enroute.student_grade.dto;

import com.enroute.student_grade.model.entity.Student;
import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public static StudentDTO fromEntity(Student s) {
        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setEmail(s.getEmail());
        dto.setDob(s.getDob());
        return dto;
    }
}