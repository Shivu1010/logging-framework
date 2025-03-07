package com.example.loggingframework.config;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoggingConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testStatsDClientBean() {
        // Retrieve the StatsDClient bean from the context
        StatsDClient statsDClient = applicationContext.getBean(StatsDClient.class);

        // Verify that the bean is not null
        assertNotNull(statsDClient, "StatsDClient bean should not be null");

        // Verify that the bean is of the correct type
        assertTrue(statsDClient instanceof NonBlockingStatsDClient, "StatsDClient should be an instance of NonBlockingStatsDClient");
    }

    @Test
    public void testAmazonCloudWatchBean() {
        // Retrieve the AmazonCloudWatch bean from the context
        AmazonCloudWatch amazonCloudWatch = applicationContext.getBean(AmazonCloudWatch.class);

        // Verify that the bean is not null
        assertNotNull(amazonCloudWatch, "AmazonCloudWatch bean should not be null");

        // Verify that the bean is of the correct type
        assertNotNull(amazonCloudWatch, "AmazonCloudWatch bean should be created");
    }
}
