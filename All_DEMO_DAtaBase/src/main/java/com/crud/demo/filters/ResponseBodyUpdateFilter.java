package com.crud.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
* STEPS
* ======
*   Wrap the real response to the ContentCachingResponseWrapper
*   Pass wrapper through chain
*   read the cached body by -  byte[] contentAsByteArray = responseWrapper.getContentAsByteArray();
*   clear the cached body before replacing - responseWrapper.resetBuffer();
*   write the replacement body -  responseWrapper.getWriter().write(modifiedBody);
*   copy tp the real response - responseWrapper.copyBodyToResponse();
* */

/*
* Limitations of mannual modifying response body
*   - The response body may be empty - as it is an stream
*   - The body may not contain JSON
*   - The original JSON mau be mallformed
*   - binary files , and others may get compromised
*   - Buffering large file consimes memory
*   - Existing header like content-length , Etag and few more gets invalid
*   -
* */


/* basically this class used for to change existing incoming response body from the controller */
// Not A good practice
@Slf4j
//@Component
public class ResponseBodyUpdateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response; // type casted to HttpServletResponse

        // Put in ContentCachingResponseWrapper for enabling responsebody modification after the DispatcherServlet returned.
        // Here we are not sending the original httpServletResponse to DispatcherServlet and controllers, we are wrapping it and modifying when it comes back.
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);

        try {
            chain.doFilter(request, responseWrapper);
        } finally {

            byte[] contentAsByteArray = responseWrapper.getContentAsByteArray(); // we received the original response body from DispatcherServlet as a stream
            String originalBody = new String(contentAsByteArray , StandardCharsets.UTF_8); // we transfored to stream -- to string

            // Formatted as for our requirement
            String modifiedBody = """
                    {
                        "originalResponse" : %s,
                        "appname" : "Student Application returned"
                    }
                    """.formatted(originalBody);
            byte[] modifiedBodyBytes = modifiedBody.getBytes(StandardCharsets.UTF_8);

            //clear the currently cached body and but keep the headers and statuses.
            responseWrapper.resetBuffer();

            responseWrapper.setContentType("application/json");
            responseWrapper.setCharacterEncoding(StandardCharsets.UTF_8.name());

            // Now writing into servlet the modified String
            responseWrapper.getWriter().write(modifiedBody);

      //    now coping the final body to httpServletResponse
            responseWrapper.copyBodyToResponse();

        }
    }

}
