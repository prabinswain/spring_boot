package com.crud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication // (exclude = DataSourceAutoConfiguration.class)
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);

//        SpringApplication app = new SpringApplication(StudentApplication.class);
//        app.setApplicationStartup(new BufferingApplicationStartup(2048));
//        app.run(args);
	}

}
