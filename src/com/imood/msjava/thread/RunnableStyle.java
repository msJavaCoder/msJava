package com.imood.msjava.thread;

/**
 * msJava
 *
 * @Description
 * @Date 2020-11-29
 */
public class RunnableStyle  implements Runnable{
    @Override
    public void run() {
        System.out.println("RunnableStyle ····");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
