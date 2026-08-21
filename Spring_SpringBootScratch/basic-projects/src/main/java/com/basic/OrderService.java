package com.basic;

import com.basic.notification.EmailService;
import com.basic.notification.NotificationService;
import com.basic.notification.PopUpService;

public class OrderService {

    public OrderService(){}
//    NotificationService notificationService = new EmailService();
    NotificationService notification ;



    public OrderService(NotificationService notification ){
        this.notification=notification;
    }

    public void placeOrder(){
        System.out.println("Order placed.");
        notification.sendNotification();
    }
}
