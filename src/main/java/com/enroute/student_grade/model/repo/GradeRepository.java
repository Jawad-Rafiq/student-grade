package com.enroute.student_grade.model.repo;

import com.enroute.student_grade.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {}
