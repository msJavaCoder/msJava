package com.imood.msjava.设计模式;

/**
 * msJava
 *
 * @Description 单例模式  懒汉式单例实现
 * @Date 2021-01-23
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySingleton = null;

    /**
     * 私有化构造函数
     */
    private LazySimpleSingleton() {

    }

    /**
     * 提供一个全局访问点
     *
     * @return
     */
    public static LazySimpleSingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySimpleSingleton();
        }
        return lazySingleton;
    }
}
