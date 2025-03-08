package com.example.loggingframework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration class for setting up logging aspects in the application.
 * This class enables AspectJ auto-proxying to allow for aspect-oriented programming (AOP)
 * features such as logging method executions, performance monitoring, etc.
 *
 * <p>The {@code @EnableAspectJAutoProxy} annotation enables support for handling components
 * marked with AspectJ's {@code @Aspect} annotation, allowing them to be automatically
 * proxied and woven into the application at runtime.</p>
 *
 * <p>Additional logging-related configurations, such as custom loggers, log levels, or
 * appenders, can be added to this class as needed.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.context.annotation.EnableAspectJAutoProxy
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggingConfig {
    // Additional logging configurations can be added here
}