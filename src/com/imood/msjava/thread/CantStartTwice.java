package com.imood.msjava.thread;

/**
 * msJava
 *
 * @Description   不能两次调用start方法 否则会抛出异常
 *                     java.lang.IllegalThreadStateException
 * @Date 2020-11-30
 */
public class CantStartTwice {


    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }




}
