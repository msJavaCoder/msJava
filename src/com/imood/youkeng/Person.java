package com.imood.youkeng;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/24/0024
 * @version: 1.0
 */
public class Person {


    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i]=new Thread((new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(j);
                    }
                    System.out.print(" ");
                }
            }));
        }

        for (Thread th:threads
             ) {
            th.start();
        }

    }


}
