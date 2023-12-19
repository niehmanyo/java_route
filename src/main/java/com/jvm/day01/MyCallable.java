package com.jvm.day01;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum =0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 36; i++) {
            sum+= i;
        }
        return sum;
    }
}
