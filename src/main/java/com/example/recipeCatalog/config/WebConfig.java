package com.example.recipeCatalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //@Override
    public void addCorsMapping(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("https://localhost:3000");
    }
}
