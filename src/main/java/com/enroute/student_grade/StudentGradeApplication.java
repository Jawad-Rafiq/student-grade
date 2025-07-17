package com.enroute.student_grade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class StudentGradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentGradeApplication.class, args);
	}

}
