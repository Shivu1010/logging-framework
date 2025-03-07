package com.example.loggingframework.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {

    private final DemoService demoService = new DemoService();

    @Test
    void testPerformAction() {
        String result = demoService.performAction("test");
        assertEquals("Processed: test", result);
    }

    @Test
    void testPerformActionWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> demoService.performAction(null));
    }
}