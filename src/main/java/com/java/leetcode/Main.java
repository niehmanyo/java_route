package com.java.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "abcdaca";
        int start = 0;
        int len = 0;
        int pos;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        System.out.println(map.get('e'));
    }

    @Test
    public void testSort(){
//        int [][]array = {{1,3},{1,2},{1,5}};
//        for (int i = 0; i < array.length ; i++) {
//            System.out.println(array[i][0]+" "+array[i][1]);
//        }
        Map<Integer,Integer> map = new HashMap<>();
        
    }

}
