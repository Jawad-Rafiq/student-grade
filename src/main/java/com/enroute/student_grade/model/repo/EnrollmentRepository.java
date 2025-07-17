package com.enroute.student_grade.model.repo;

import com.enroute.student_grade.model.entity.Enrollment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
}