package com.imood.msjava.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * msJava
 *
 * @Description  定时器 创建 线程
 * @Date 2020-11-29
 */
public class DemoTimerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }

}
