package com.basic.notification;

public class PopUpService implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println(" PopUp sent");
    }
}
