package com.enroute.student_grade.controller;

import com.enroute.student_grade.dto.StudentDTO;
import com.enroute.student_grade.model.entity.Student;
import com.enroute.student_grade.model.repo.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students") @RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepo;

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) {
        Student s = new Student();
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setDob(dto.getDob());
        return ResponseEntity.ok(StudentDTO.fromEntity(studentRepo.save(s)));
    }

    @GetMapping
    public Page<StudentDTO> list(@RequestParam(defaultValue="0") int page,
                                 @RequestParam(defaultValue="10") int size,
                                 @RequestParam(defaultValue="id") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return studentRepo.findAll(pageable).map(StudentDTO::fromEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable Long id) {
        return studentRepo.findById(id)
                .map(StudentDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}