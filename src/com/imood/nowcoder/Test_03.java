package com.imood.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/24/0024
 * @version: 1.0
 */
public class Test_03 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String[] tmp = s.substring(1, s.length() - 1).split(",");
        int[] arr = new int[n + 1];
        int[] p = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            p[i] = Integer.parseInt(tmp[i]);
        }

        arr[0] = 1;

        for(int a : p) {
            for(int i = a; i < arr.length; i++) {
                arr[i] = (arr[i] + arr[i - a]);
            }
        }

        System.out.println(arr[n]);
    }
}
