package com.java.basic;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

        int a = 1;
        Collection<String> list = new ArrayList<>();
        list.add("java1");
        list.add("asd");
        list.add("asdasd");
        int []ans = {1,2,3,4,5};
        int []copy = ans.clone();

        // 集合转成数组的写法
        String[] arr = list.toArray(new String[list.size()]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //foreach 遍历
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 简化foreach表达式
        list.forEach(s -> {
            System.out.println(s);
        });

        // 清空集合
        list.clear();

        Stack<Integer> stack = new Stack<>();

    }

    @Test
    public void leetcode(){
        System.out.println('a'-'b');

    }
}
