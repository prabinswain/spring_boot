package com.core;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);
    }
}
