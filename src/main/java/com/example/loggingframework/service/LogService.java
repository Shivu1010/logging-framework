package com.example.loggingframework.service;

import org.springframework.stereotype.Service;

/**
 * Service class containing business logic.
 */
@Service
public class DemoService {

    /**
     * Processes the input and returns a result.
     *
     * @param input The input string.
     * @return The processed result.
     * @throws IllegalArgumentException If the input is null.
     */
    public String performAction(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return "Processed: " + input;
    }
}