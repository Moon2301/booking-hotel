package com.hotel.booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Cho phép tất cả endpoint
                .allowedOrigins("http://localhost:3000") // Địa chỉ frontend React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các method
                .allowedHeaders("*") // Cho phép tất cả headers
                .allowCredentials(true); // Cho phép gửi cookie, token
    }
}
