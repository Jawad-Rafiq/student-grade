package com.enroute.student_grade.service;

import com.enroute.student_grade.service.impl.ImportServiceImpl.ImportStatus;
import org.springframework.web.multipart.MultipartFile;

public interface ImportService {
  public String startImport(MultipartFile file);
  public ImportStatus getStatus(String id);
}
