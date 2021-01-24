package com.imood.msjava.设计模式;

/**
 * msJava
 *
 * @Description 单例模式  饿汉式静态机制 实现
 * @Date 2021-01-23
 */
public class HungryStaticSingleton {


    private static final HungryStaticSingleton hungrySingleton;

    //静态代码块 类加载的时候就初始化
    static {
        hungrySingleton=new HungryStaticSingleton();
    }

    /**
     * 私有化构造函数
     */
    private HungryStaticSingleton(){

    }

    /**
     * 提供一个全局访问点
     * @return
     */
    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }


}
