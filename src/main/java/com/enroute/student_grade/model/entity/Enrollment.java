package com.enroute.student_grade.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Student student;
  @ManyToOne(optional = false)
  private Course course;

  private LocalDate enrollmentDate = LocalDate.now();

  @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
  private List<Grade> grades = new ArrayList<>();
}
