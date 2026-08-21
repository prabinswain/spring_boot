package com.mvc;

import com.mvc.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello Spring MVC ");

        // thigs i need to do
        // enable tomcat and set port
        Tomcat tomcat = new Tomcat(); // creating new Tomcat obj
        tomcat.setPort(8080); // setting port
        tomcat.getConnector(); // set the port to connector

        // creating web context
        String contextPath = ""; // basePath off the app
        String docBase = new File("src/main/webapp").getAbsolutePath(); // folder Tomcat expecting

        Context context = tomcat.addContext(contextPath, docBase);

        // IOC container and register
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet); // register dispatcher servlet with tomcat
        context.addServletMappingDecoded("/","dispatcherServlet");

        tomcat.start();
        tomcat.getServer().await();

        System.out.println("Tomcat started");


    }
}