package com.example.loggingframework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A service class that demonstrates logging functionality in a Spring application.
 * This class uses SLF4J for logging and simulates a task execution, including
 * logging informational messages and throwing exceptions for demonstration purposes.
 *
 * <p>The {@code @Service} annotation marks this class as a Spring service component,
 * making it a candidate for auto-detection and dependency injection.</p>
 *
 * <p>This class is intended to showcase how logging can be integrated into the service layer
 * of an application, including logging messages and handling exceptions.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see org.slf4j.Logger
 * @see org.slf4j.LoggerFactory
 * @see org.springframework.stereotype.Service
 */
@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * Simulates the execution of a task in the service layer.
     * Logs an informational message before throwing a simulated exception.
     *
     * @throws RuntimeException to simulate an error during task execution.
     */
    public void performTask() {
        logger.info("Performing a task in the service layer.");
        // Simulate an error
        throw new RuntimeException("Simulated error in service layer");
    }
}