package com.basic.notification;

public class FakeNotofication implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("dumuy notification sent.");
    }
}
