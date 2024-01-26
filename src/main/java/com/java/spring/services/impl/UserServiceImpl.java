package com.java.spring.services.impl;

import com.java.spring.services.UserService;
import com.java.spring.user.UserDAO;

public class UserServiceImpl implements UserService {

    private String xxx;
    @Override
    public void setUserDao(UserDAO userDAO) {
        System.out.println("BeanFactory" + userDAO.toString());
    }
}
