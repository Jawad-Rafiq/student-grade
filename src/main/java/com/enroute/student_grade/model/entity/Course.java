package com.enroute.student_grade.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String code;
  @NotBlank
  private String title;
  @Positive
  private int capacity;
  private String prerequisites;
  private boolean completed;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<Enrollment> enrollments = new ArrayList<>();
}