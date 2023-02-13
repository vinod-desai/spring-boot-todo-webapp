package com.java.example.todoapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        // Send the index.html for the full path
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
