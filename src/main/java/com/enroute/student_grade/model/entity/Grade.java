package com.enroute.student_grade.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDate;

@Entity @Data
public class Grade {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) private Enrollment enrollment;

  @Pattern(regexp = "A|B|C|D|F")
  private String gradeValue;

  private LocalDate recordedOn = LocalDate.now();
}
