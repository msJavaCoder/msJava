package com.imood;


import java.util.HashMap;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
public class Main {


    public static int sum(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {

        int a=3;
        int b=2;
        System.out.println(a+=a*sum(a,b)*b);

    }


}
