package com.java.spring.user.impl;

import com.java.spring.user.UserDAO;

public class UserDAOImpl implements UserDAO {
    @Override
    public void print() {
        System.out.println(version);
    }
}
