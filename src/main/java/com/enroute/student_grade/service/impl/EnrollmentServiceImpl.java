package com.enroute.student_grade.service.impl;

import com.enroute.student_grade.model.entity.Course;
import com.enroute.student_grade.model.entity.Enrollment;
import com.enroute.student_grade.model.entity.Student;
import com.enroute.student_grade.model.repo.CourseRepository;
import com.enroute.student_grade.model.repo.EnrollmentRepository;
import com.enroute.student_grade.model.repo.StudentRepository;
import com.enroute.student_grade.service.EnrollmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollRepo;

    @Transactional
    @Override
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();

      if (course.getEnrollments().size() >= course.getCapacity()) {
        throw new IllegalStateException("Course capacity full");
      }

        if (course.getPrerequisites() != null) {
            boolean hasPreReq = student.getEnrollments().stream()
                    .map(e -> e.getCourse().getCode())
                    .anyMatch(code -> code.equals(course.getPrerequisites()));
          if (!hasPreReq) {
            throw new IllegalStateException("Prerequisite not met");
          }
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollRepo.save(enrollment);
    }
}