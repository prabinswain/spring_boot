package com.crud.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("The request URI : " + request.getRequestURI());
        System.out.println("The request URL : " + request.getRequestURL());
        System.out.println("The context path : " + request.getContextPath());
        System.out.println("Controller called method name : " + request.getMethod());
        System.out.println("Query string  : " + request.getQueryString());
        System.out.println("The IP address : " + request.getRemoteAddr());
        System.out.println("The the LocalPort : " + request.getLocalPort());
        System.out.println("The the getRemotePort : " + request.getRemotePort());
        System.out.println("The the getServerPort : " + request.getServerPort());

//        if (handler instanceof HandlerInterceptor handlerInterceptor){
//            System.out.println(handlerInterceptor.);
//        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("inside postHandle method ");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                               @Nullable Exception ex) throws Exception {
        System.out.println("Controller returned status : " + response.getStatus());
    }



}
