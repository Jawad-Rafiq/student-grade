package com.enroute.student_grade.model.repo;

import com.enroute.student_grade.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
