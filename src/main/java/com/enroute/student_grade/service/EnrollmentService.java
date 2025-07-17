package com.enroute.student_grade.service;

import com.enroute.student_grade.model.entity.Enrollment;

public interface EnrollmentService {
  Enrollment enrollStudent(Long studentId, Long courseId);
}
