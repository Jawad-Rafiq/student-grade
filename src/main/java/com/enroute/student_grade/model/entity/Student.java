package com.enroute.student_grade.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;
  @Email
  @NotBlank
  private String email;
  @Past
  private LocalDate dob;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Enrollment> enrollments = new ArrayList<>();
}
