package com.enroute.student_grade.dto;

import com.enroute.student_grade.model.entity.Course;
import lombok.Data;

@Data
public class CourseDTO {
    private Long id;
    private String code;
    private String title;
    private int capacity;
    private String prerequisites;
    private boolean completed;

    public static CourseDTO fromEntity(Course c) {
        CourseDTO dto = new CourseDTO();
        dto.setId(c.getId());
        dto.setCode(c.getCode());
        dto.setTitle(c.getTitle());
        dto.setCapacity(c.getCapacity());
        dto.setPrerequisites(c.getPrerequisites());
        dto.setCompleted(c.isCompleted());
        return dto;
    }
}