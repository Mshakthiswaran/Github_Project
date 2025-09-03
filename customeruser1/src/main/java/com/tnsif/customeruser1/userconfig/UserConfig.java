package com.tnsif.customeruser1.userconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class UserConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200") // ✅ Removed trailing slash
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*") // ✅ Added for flexibility
            .allowCredentials(true); // ✅ Optional for cookies/session
    }
}