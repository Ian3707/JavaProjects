package com.lesson1.config;

import com.lesson1.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "courseService")
    public CourseService getCourseService(){
        return new CourseService();
    }

}
