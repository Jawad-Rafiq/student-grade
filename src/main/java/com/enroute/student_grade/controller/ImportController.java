package com.enroute.student_grade.controller;

import com.enroute.student_grade.service.ImportService;
import com.enroute.student_grade.service.impl.ImportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import") @RequiredArgsConstructor
public class ImportController {
    private final ImportService importService;

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) {
        return importService.startImport(file);
    }

    @GetMapping("/{id}/status")
    public ImportServiceImpl.ImportStatus status(@PathVariable String id) {
        return importService.getStatus(id);
    }
}