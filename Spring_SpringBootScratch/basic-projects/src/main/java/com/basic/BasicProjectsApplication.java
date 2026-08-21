package com.basic;

import com.basic.controller.HelloController;
import com.basic.notification.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicProjectsApplication.class, args);

        NotificationService notificationService = new FakeNotofication();
        System.out.println("Inside main method");

        OrderService orderService = new OrderService(notificationService);
        orderService.placeOrder();
	}

}
