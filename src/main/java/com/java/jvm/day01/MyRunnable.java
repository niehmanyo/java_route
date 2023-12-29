package com.java.jvm.day01;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " " + i);
        }
    }
}
