package com.imood.msjava.设计模式;

/**
 * msJava
 *
 * @Description 单例模式的通用写法
 * @Date 2021-01-23
 */
public class Singleton {

    /**
     * 内部初始化一次
     */
    private static final Singleton instance = new Singleton();


    /**
     * 隐藏构造方法
     */
    private Singleton() {
    }

    /**
     * 提供一个全局访问点
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return instance;
    }


}
