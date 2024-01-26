package com.java.spring.test;

import com.java.spring.services.UserService;
import com.java.spring.user.UserDAO;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        //创建工厂对象， 这个类存在springboot 依赖里面
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 创建一个读取器xml
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        //
        reader.loadBeanDefinitions("beans.xml");

        UserService userService = (UserService) defaultListableBeanFactory.getBean("UserService");
        UserDAO userDAO = (UserDAO) defaultListableBeanFactory.getBean("UserDAO");

        System.out.println(userService);
        System.out.println(userDAO);
        userDAO.print();
        userService.setUserDao(userDAO);

    }

}
