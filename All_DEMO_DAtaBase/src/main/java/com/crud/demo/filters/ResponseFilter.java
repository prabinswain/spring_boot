package com.crud.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
@Order(3)
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // before sending the request to DispatcherServlet or filter chain to another filter
        // we casted to HttpServletRequest and HttpServletResponse to do some operation from HttpServletRequest and response as well
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        System.out.println("call in auth filter");
//        String authToken = UUID.randomUUID().toString();
        httpServletResponse.setHeader("authToken",UUID.randomUUID().toString());
        // setHeader replaces the existing header
        httpServletResponse.setHeader("authToken",UUID.randomUUID().toString());

        // And the addHeader will create another header in response
        httpServletResponse.addHeader("jwtHeader",UUID.randomUUID().toString());
        // it adds another header and, even though a header is present
//        httpServletResponse.addHeader("jwtHeader",UUID.randomUUID().toString());

        try {
            chain.doFilter(request, response);
        } finally {
            // when the response will come from Dispatcher servlet or from another filter
            System.out.println("IN finally auth");
        }

    }
}
