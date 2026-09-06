package com.crud.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class ExecutionTime implements WebMvcConfigurer, HandlerInterceptor {

    // 1. Triggered BEFORE the request reaches your Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    //// 2. Triggered AFTER the response is fully completed and sent to the client
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        long executionTime = System.currentTimeMillis() - ((Long) request.getAttribute("startTime")) ;
        System.out.println("The execution time ; " + executionTime );

    }
}
