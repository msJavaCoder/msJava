package com.imood;


/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
public class Main {

    public final static int num=1;
    public int nums=2;

    public int say(){
        int a=Main.ha();
        return a;
    }

    public static int ha(){
        int a=new Main().say();
        return a;
    }


    public static void main(String[] args) {

    }
}
