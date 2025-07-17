package com.enroute.student_grade.service.impl;

import com.enroute.student_grade.service.ImportService;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportServiceImpl implements ImportService {
    private final Map<String, ImportStatus> statusMap = new ConcurrentHashMap<>();

    @Async
    @Override
    public String startImport(MultipartFile file) {
        String id = UUID.randomUUID().toString();
        statusMap.put(id, new ImportStatus("IN_PROGRESS", 0));

        CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(30);
                    statusMap.put(id, new ImportStatus("IN_PROGRESS", i));
                }
                statusMap.put(id, new ImportStatus("COMPLETED", 100));
            } catch (Exception e) {
                statusMap.put(id, new ImportStatus("FAILED", 0));
            }
        });
        return id;
    }

    @Override
    public ImportStatus getStatus(String id) {
        return statusMap.getOrDefault(id, new ImportStatus("UNKNOWN", 0));
    }

    @Data
    public static class ImportStatus {
        private final String state;
        private final int progress;
    }
}