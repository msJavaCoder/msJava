package com.imood.msjava.thread;


/**
 * msJava
 *
 * @Description
 * @Date 2020-11-29
 */
public class ThreadStyle extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadStyle  ····");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
