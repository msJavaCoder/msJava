package com.imood;

import java.util.Scanner;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
public class Main {

    public static boolean balanceNum(int n){
        String str = String.valueOf(n);
        int length=str.length();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        int count=0;
        int begin=0;
        int end=length-1;
        int result1=1;
        int result2=1;

        if(n<10){
            return false;
        }

        for (int c: ints) {
            if (c==0){
                count++;
            }
        }

        if(count>=2){
            return true;
        }

        if(count==1){
            return false;
        }

        while (begin<=end){
            if(result1<result2){
                result1*=ints[begin];
                begin++;
            }else {
                result2*=ints[end];
                end--;
            }
        }
        if(result1==result2){
            return true;
        }else {
            return false;
        }

    }
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean result= balanceNum(n);
        if(result==true){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
