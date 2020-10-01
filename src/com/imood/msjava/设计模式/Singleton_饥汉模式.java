package com.imood.msjava.设计模式;

/**
 * @description: 单例模式——饥汉模式
 * —— 在类加载时就会进行单例的初始化，以后访问时直接使用单例对象即可。
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/26/0026
 * @version: 1.0
 */
public class Singleton_饥汉模式 {

    //声明私有对象
    private static Singleton_饥汉模式 instance = new Singleton_饥汉模式();

    // 获取实例（单例对象）
    public static Singleton_饥汉模式 getInstance() {
        return instance;
    }

    //私有化构造方法
    private Singleton_饥汉模式() {

    }

    public void sayHi() {
        System.out.println("Hi,Java");
    }

    public static void main(String[] args) {

        Singleton_饥汉模式 instance = Singleton_饥汉模式.getInstance();
        instance.sayHi();

    }

}
