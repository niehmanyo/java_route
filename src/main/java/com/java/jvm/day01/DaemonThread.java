package com.java.jvm.day01;

public class DaemonThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"@"+i);
        }
    }

    public DaemonThread(){

    }

    public DaemonThread(String name){
        super(name);
    }
}
