package com.imood.msjava.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author msJava
 * @Description: 剑指 Offer 50. 第一个只出现一次的字符
 */
public class FirstUniqChar_50 {

    public static char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character,Boolean> map=new HashMap<>();

        for (char c : array) {
            map.put(c,!map.containsKey(c));
        }

        for (char c : array) {
            if(map.get(c)){
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);

    }
}
