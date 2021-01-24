package com.imood.msjava.设计模式;

/**
 * msJava
 *
 * @Description 单例模式  静态内部类单例实现
 * @Date 2021-01-23
 */
public class LazyStaticInnerClassSingleton {

    //  在构造方法里面抛出异常真的合适？
    //
  private LazyStaticInnerClassSingleton(){
    if(LazyHolder.INSTANCE != null){
        throw new RuntimeException("不允许创建多个实例");
    }
  }

  // static 保证这个方法不会被重写 覆盖
  private static LazyStaticInnerClassSingleton getInstance(){
      return LazyHolder.INSTANCE;
  }


  // Java 默认不会加载内部类
  private static class LazyHolder{
      private static final LazyStaticInnerClassSingleton INSTANCE=new LazyStaticInnerClassSingleton();
  }
}
