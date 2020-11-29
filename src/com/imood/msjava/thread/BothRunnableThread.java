package com.imood.msjava.thread;

/**
 * msJava
 *
 * @Description
 * @Date 2020-11-29
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();

        /**
         * lambda 表达式 创建线程
         */
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
