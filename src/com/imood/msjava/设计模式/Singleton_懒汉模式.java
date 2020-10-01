package com.imood.msjava.设计模式;

/**
 * @description: 单例模式——懒汉模式也被称作为饱汉模式，
 * ——当每次需要使用实例时，再去创建获取实例，而不是在类加载时就将实例创建好。
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/26/0026
 * @version: 1.0
 */
public class Singleton_懒汉模式 {

    //声明私有对象
    private static Singleton_懒汉模式 instance;

    // 获取实例（单例对象）
    public static Singleton_懒汉模式 getInstance() {

        if (instance == null) {
            instance = new Singleton_懒汉模式();
        }
        return instance;
    }

    //私有化构造方法
    private Singleton_懒汉模式() {

    }

    public void sayHi() {
        System.out.println("Hi,Java");
    }

    public static void main(String[] args) {

        Singleton_懒汉模式 instance = Singleton_懒汉模式.getInstance();
        instance.sayHi();

    }

}
