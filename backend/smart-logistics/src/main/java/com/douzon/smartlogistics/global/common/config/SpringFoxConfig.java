package com.douzon.smartlogistics.global.common.config;

import static springfox.documentation.builders.PathSelectors.regex;

import com.douzon.smartlogistics.global.common.config.interceptor.SessionAuthInterceptor;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import com.fasterxml.classmate.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// http://localhost:8888/swagger-ui/index.html

@RequiredArgsConstructor
@Configuration
public class SpringFoxConfig extends WebMvcConfigurationSupport {

    private final SessionAuthInterceptor sessionAuthInterceptor;

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
                .additionalModels(typeResolver.resolve(CommonResponse.class))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionAuthInterceptor).addPathPatterns("/api/member/*");
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Smart-Logistics-Project-Rest-Docs-Swagger")
                .description("스마트 물류 관리 백엔드 서버의 Rest Docs 입니다.")
                .version("0.1")
                .build();
    }
}