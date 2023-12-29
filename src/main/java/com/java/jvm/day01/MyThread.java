package com.java.jvm.day01;

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName() + " " + i);

            //表示出让当前 CPU 的执行权
//            Thread.yield();

        }
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
        super();
    }
}
