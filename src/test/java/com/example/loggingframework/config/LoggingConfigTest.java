package com.example.loggingframework.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for {@link LoggingConfig}.
 * Verifies that the Spring context loads correctly and that AspectJ auto-proxying is enabled.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LoggingConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Tests that the Spring context loads successfully and the {@link LoggingConfig} class is properly configured.
     */
    @Test
    public void testContextLoads() {
        // Verify that the application context is not null
        assertNotNull(applicationContext, "Application context should not be null");
    }

    /**
     * Tests that the AspectJ auto-proxy creator is registered in the Spring context.
     * This ensures that the {@code @EnableAspectJAutoProxy} annotation is working as expected.
     */
    @Test
    public void testAspectJAutoProxyEnabled() {
        // Check if the AnnotationAwareAspectJAutoProxyCreator bean is registered
        AnnotationAwareAspectJAutoProxyCreator proxyCreator =
                applicationContext.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        assertNotNull(proxyCreator, "AnnotationAwareAspectJAutoProxyCreator should be registered in the context");
    }
}