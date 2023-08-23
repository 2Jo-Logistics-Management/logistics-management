package com.douzon.smartlogistics.global.common.config;

import com.douzon.smartlogistics.global.common.config.interceptor.SessionCheckInterceptor;
import com.douzon.smartlogistics.global.common.converter.StringToStateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToStateConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .allowedHeaders("*");
    }

    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionCheckInterceptor())
                .addPathPatterns("/**");
    }



}
