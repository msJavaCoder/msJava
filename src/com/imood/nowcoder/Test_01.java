package com.imood.nowcoder;

import java.util.Scanner;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
public class Test_01 {


    /**
     * 原地翻转句子中单词的顺序，但单词内字符的顺序不变。要求：空间复杂度O(1)，时间复杂度O(n)。
     * @param str
     * @return
     */
    public static String reserve(String str){
        String[] strings = str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
            sb.append(strings[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String reserve = reserve(str);
        System.out.print(reserve+" ");
    }
}
