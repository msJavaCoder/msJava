package com.imood.nowcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/20/0020
 * @version: 1.0
 */
public class Solution {


    public static String Typing (String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=0;
        if(chars[0]=='<'){
            return sb.toString();
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='<'&& count==0){
                sb.deleteCharAt(sb.length() - 1);
            }
            if(chars[i]!='<') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        String typing = Solution.Typing(next);
        System.out.println(typing);
    }
}
