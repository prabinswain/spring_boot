package com.crud.demo.interceptor.config;

import com.crud.demo.interceptor.ExecutionTime;
import com.crud.demo.interceptor.LoggingInceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    private LoggingInceptor loggingInceptor;
    private ExecutionTime executionTime;

    public WebConfig(LoggingInceptor loggingInceptor , ExecutionTime executionTime) {
        this.loggingInceptor = loggingInceptor;
        this.executionTime = executionTime;
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loggingInceptor).addPathPatterns("/api/**").order(1);
        registry.addInterceptor(executionTime).addPathPatterns("/api/**").order(2);
    }

}
