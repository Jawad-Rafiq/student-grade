package com.enroute.student_grade.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .info(new Info().title("School Management API")
            .version("v1.0")
            .description("Student, Course, Enrollment, Grade Management"));
  }
}
