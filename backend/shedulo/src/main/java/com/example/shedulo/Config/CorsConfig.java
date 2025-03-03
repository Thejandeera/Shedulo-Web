package com.example.shedulo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all endpoints
                .allowedOrigins("http://localhost:5173")  // Allow only your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow only specific methods
                .allowedHeaders("*");  // Allow all headers
    }
}
