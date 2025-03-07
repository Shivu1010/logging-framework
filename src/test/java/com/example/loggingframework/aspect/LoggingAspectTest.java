package com.example.loggingframework.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoggingAspectTest {

    @Mock
    private Logger logger; // Mock the Logger

    @Mock
    private JoinPoint joinPoint; // Mock the JoinPoint

    @Mock
    private Signature signature; // Mock the Signature

    @InjectMocks
    private LoggingAspect loggingAspect; // Inject mocks into the LoggingAspect

    @BeforeEach
    public void setUp() {
        // Mock the Signature to return a method name
        when(signature.getName()).thenReturn("sampleMethod");

        // Mock the JoinPoint to return the mocked Signature
        when(joinPoint.getSignature()).thenReturn(signature);

        // Mock the JoinPoint arguments to return a sample array of arguments
        when(joinPoint.getArgs()).thenReturn(new Object[] { "arg1", "arg2" });
    }

    @Test
    public void testLogBefore() {
        // Call the aspect method
        loggingAspect.logBefore(joinPoint);

        // Verify that the logger was called with the expected message
        verify(logger).info("Entering method: {} with arguments: {}", "sampleMethod", new Object[] { "arg1", "arg2" });
    }

    @Test
    public void testLogAfterReturning() {
        // Simulate a method returning a result
        Object result = "success";

        // Call the aspect method
        loggingAspect.logAfterReturning(joinPoint, result);

        // Verify that the logger was called with the expected message
        verify(logger).info("Exiting method: {} with result: {}", "sampleMethod", result);
    }

    @Test
    public void testLogAfterThrowing() {
        // Simulate an exception being thrown
        Throwable error = new RuntimeException("Test exception");

        // Call the aspect method
        loggingAspect.logAfterThrowing(joinPoint, error);

        // Verify that the logger was called with the expected error message
        verify(logger).error("Exception in method: {} with cause: {}", "sampleMethod", "Test exception");
    }
}