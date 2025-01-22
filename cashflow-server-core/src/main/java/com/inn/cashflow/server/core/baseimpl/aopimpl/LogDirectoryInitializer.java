package com.inn.cashflow.server.core.baseimpl.aopimpl;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.io.File;

@Component
public class LogDirectoryInitializer {

    @PostConstruct
    public void createLogDirectory() {
        File logDir = new File("logs");
        if (!logDir.exists()) {
            boolean created = logDir.mkdirs();
            if (created) {
                System.out.println("Log directory created: " + logDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create log directory.");
            }
        }
    }
}
