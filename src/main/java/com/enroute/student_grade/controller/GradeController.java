package com.enroute.student_grade.controller;

import com.enroute.student_grade.model.entity.Grade;
import com.enroute.student_grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades") @RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    public Grade record(@RequestParam Long studentId, @RequestParam Long courseId, @RequestParam String gradeValue) {
        return gradeService.recordGrade(studentId, courseId, gradeValue);
    }
}