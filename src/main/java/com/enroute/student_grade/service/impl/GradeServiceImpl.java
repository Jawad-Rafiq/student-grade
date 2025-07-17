package com.enroute.student_grade.service.impl;

import com.enroute.student_grade.model.entity.Enrollment;
import com.enroute.student_grade.model.entity.Grade;
import com.enroute.student_grade.model.repo.EnrollmentRepository;
import com.enroute.student_grade.model.repo.GradeRepository;
import com.enroute.student_grade.service.GradeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final EnrollmentRepository enrollRepo;
    private final GradeRepository gradeRepo;

    @Transactional
    @Override
    public Grade recordGrade(Long studentId, Long courseId, String gradeValue) {
        Enrollment enrollment = enrollRepo.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

      if (enrollment.getCourse().isCompleted()) {
        throw new IllegalStateException("Course completed");
      }

        Grade grade = new Grade();
        grade.setEnrollment(enrollment);
        grade.setGradeValue(gradeValue);
        return gradeRepo.save(grade);
    }
}