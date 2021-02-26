package com.imood.msjava.leetcode;


import java.util.Stack;

/**
 * @author msJava
 * @Description: 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates_1047 {

    public static String removeDuplicates(String s){

        char[] array = s.toCharArray();

        Stack<Character> stack=new Stack<>();
        for (char c : array) {
            if( stack.isEmpty() || c!=stack.peek()){
                stack.push(c);
            }else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return  sb.toString();
    }


    public static void main(String[] args) {
        String s="abbaca";
        String removeDuplicates = removeDuplicates(s);
        System.out.println(removeDuplicates);
    }
}
