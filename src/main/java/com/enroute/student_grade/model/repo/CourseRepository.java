package com.enroute.student_grade.model.repo;

import com.enroute.student_grade.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}
