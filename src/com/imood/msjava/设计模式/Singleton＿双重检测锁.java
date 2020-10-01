package com.imood.msjava.设计模式;


/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/26/0026
 * @version: 1.0
 */
public class Singleton＿双重检测锁 {

    /**
     * instance = new Singleton() 这行代码。这行代码看似是一个原子操作，然而并不是，
     * 这行代码最终会被编译成多条汇编指令，它大致的执行流程为以下三个步骤：
     * <p>
     * 1. 给对象实例分配内存空间；
     * 2. 调用对象的构造方法、初始化成员字段；
     * 3. 将 instance 对象指向分配的内存空间。
     * <p>
     * 但由于 CPU 的优化会对执行指令进行重排序，
     * 也就说上面的执行流程的执行顺序有可能是 1-2-3，也有可能是 1-3-2。假如执行的顺序是 1-3-2，
     * 那么当 A 线程执行到步骤 3 时，切换至 B 线程了，而此时 B 线程判断 instance 对象已经指向了对应的内存空间，
     * 并非为 null 时就会直接进行返回，而此时因为没有执行步骤 2，因此得到的是一个未初始化完成的对象，这样就导致了问题的诞生。
     * <p>
     * 执行时间节点如下表所示：
     * 时间点	线程	   执行操作
     * t1	    A	  instance = new Singleton() 的 1-3 步骤，待执行步骤 2
     * t2	    B	  if (instance == null) { 判断结果为 false
     * t3    	B	  返回半初始的 instance 对象
     * 为了解决此问题，我们可以使用关键字 volatile 来修饰 instance 对象，
     * 这样就可以防止 CPU 指令重排，从而完美地运行懒汉模式，
     */
    private static volatile Singleton＿双重检测锁 instance;

    public static Singleton＿双重检测锁 getInstance() {
        //第一次判断
        if (instance == null) {
            synchronized (Singleton＿双重检测锁.class) {
                //第二次判断
                if (instance == null) {
                    instance = new Singleton＿双重检测锁();
                }
            }
        }
        return instance;
    }

    private Singleton＿双重检测锁() {

    }


}
