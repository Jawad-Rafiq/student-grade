package com.enroute.student_grade.service;

import com.enroute.student_grade.model.entity.Grade;

public interface GradeService {
  Grade recordGrade(Long studentId, Long courseId, String gradeValue);
}
