package com.product.product_services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapping /images/** to the directory where images are stored
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///D:/Fawry-toutorial/Final_Project/product-services-1/src/main/resources/static/images/");
    }
}