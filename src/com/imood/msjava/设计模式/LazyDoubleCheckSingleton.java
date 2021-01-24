package com.imood.msjava.设计模式;

/**
 * msJava
 *
 * @Description 单例模式  懒汉式单例实现
 * @Date 2021-01-23
 */
public class LazyDoubleCheckSingleton {

    // volatile 关键字修饰
    private volatile static LazyDoubleCheckSingleton lazySingleton ;

    /**
     * 私有化构造函数
     */
    private LazyDoubleCheckSingleton() {

    }

    /**
     * 提供一个全局访问点
     *
     * @return
     */
    public static LazyDoubleCheckSingleton getInstance() {
        // 这里先判断一下是否阻塞
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class){
                // 判断是否需要重新创建实例
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}
