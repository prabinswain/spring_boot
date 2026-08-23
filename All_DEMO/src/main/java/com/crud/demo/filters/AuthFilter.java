package com.crud.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;


/* Sets the status and returns to the client as Unauthorized. with status code 401*/
//@Component
//@Order(2)
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // before sending the request to DispatcherServlet or filter chain to another filter
        // we casted to HttpServletRequest and HttpServletResponse to do some operation from HttpServletRequest and response as well

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        System.out.println("In token filter ");

        String jwtToken = httpServletRequest.getHeader("jwtToken");

        if (jwtToken == null || !jwtToken.equals("jwt123")) {
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\"; \"Authentication required.\" \n" +
                            "}"
            );
            return;

        }
        System.out.println("call did not returned ");
        try {
            chain.doFilter(request, response);
        } finally {
            // when the response will come from Dispatcher servlet or from another filter
            System.out.println("IN finally ");
        }

    }
}
