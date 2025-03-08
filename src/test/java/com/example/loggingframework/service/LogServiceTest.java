package com.example.loggingframework.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Unit tests for {@link LogService}.
 * Verifies the logging and exception-throwing behavior of the service.
 */
@ExtendWith(MockitoExtension.class)
public class LogServiceTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private LogService demoService;

    /**
     * Tests that the {@link LogService#performTask()} method logs a message and throws an exception.
     */
    @Test
    public void testPerformTask() {
        // Act and Assert: Verify that the method throws an exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            demoService.performTask();
        }, "Expected performTask() to throw a RuntimeException");

        // Verify that the logger was called with the expected message
        verify(logger).info("Performing a task in the service layer.");

        // Verify that no other interactions occurred with the logger
        verifyNoMoreInteractions(logger);

        // Verify the exception message
        assertThat(exception.getMessage()).isEqualTo("Simulated error in service layer");
    }
}