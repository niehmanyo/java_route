package com.java.spring.test;

import com.java.spring.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContextTest = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContextTest.getBean("UserService");
        System.out.println(userService);
    }
}
