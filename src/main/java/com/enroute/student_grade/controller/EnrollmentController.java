package com.enroute.student_grade.controller;

import com.enroute.student_grade.model.entity.Enrollment;
import com.enroute.student_grade.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/enrollments") @RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.enrollStudent(studentId, courseId);
    }
}