
# Callable和Runnable的不同？

> 本文我们一起学习 Callable 和 Runnable 的不同。

## Runnable接口
首先，我们先来看看Runnable有什么缺点？
### 1.不能返回一个返回值
第一个缺陷，对于 Runnable 而言，它不能返回一个返回值，虽然可以利用其他的一些办法，比如在 Runnable 方法中写入日志文件或者修改某个共享的对象的办法，来达到保存线程执行结果的目的，但这种解决问题的行为千曲百折，属于曲线救国，效率着实不高。

实际上，在很多情况下执行一个子线程时，我们都希望能得到执行的任务的结果，也就是说，我们是需要得到返回值的，比如请求网络、查询数据库等。可是 Runnable 不能返回一个返回值，这是它第一个非常严重的缺陷。

### 2. 不能抛出 checked Exception
第二个缺陷就是不能抛出 checked Exception，如下面这段代码所示：

```java
public class RunThrowException {
   /**
    * 普通方法内可以 throw 异常，并在方法签名上声明 throws
    */
   public void normalMethod() throws Exception {
       throw new IOException();
   }
   Runnable runnable = new Runnable() {
       /**
        *  run方法上无法声明 throws 异常，且run方法内无法 throw 出 checked Exception，除非使用try catch进行处理
        */
       @Override
       public void run() {
           try {
               throw new IOException();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}
```
在这段代码中，有两个方法，第一个方法是一个普通的方法，叫作 normalMethod，可以看到，在它的方法签名中有 throws Exception，并且在它的方法内也 throw 了一个 new IOException()。

然后在下面的的代码中，我们新建了一个 Runnable 对象，同时重写了它的 run 方法，我们没有办法在这个 run 方法的方法签名上声明 throws 一个异常出来。同时，在这个 run 方法里面也没办法 throw 一个 checked Exception，除非如代码所示，用 try catch 包裹起来，但是如果不用 try catch 是做不到的。

这就是对于 Runnable 而言的两个重大缺陷。

## Callable 接口
Callable 是一个类似于 Runnable 的接口，实现 Callable 接口的类和实现 Runnable 接口的类都是可以被其他线程执行的任务。 我们看一下 Callable 的源码：

```java
public interface Callable<V> {
     V call() throws Exception;
}
```

可以看出它也是一个 interface，并且它的 call 方法中已经声明了 throws Exception，前面还有一个 V 泛型的返回值，这就和之前的 Runnable 有很大的区别。实现 Callable 接口，就要实现 call 方法，这个方法的返回值是泛型 V，如果把 call 中计算得到的结果放到这个对象中，就可以利用 call 方法的返回值来获得子线程的执行结果了。

## Callable 和 Runnable 的区别
1. 方法名，Callable 规定的执行方法是 call()，而 Runnable 规定的执行方法是 run()；
2. 返回值，Callable 的任务执行后有返回值，而 Runnable 的任务执行后是没有返回值的；
3. 抛出异常，call() 方法可抛出异常，而 run() 方法是不能抛出受检查异常的；
和 Callable 配合的有一个 Future 类，通过 Future 可以了解任务执行情况，或者取消任务的执行，还可获取任务执行的结果，这些功能都是 Runnable 做不到的，Callable 的功能要比 Runnable 强大。

## 总结
本文中我们学习了 Runnable 的两个缺陷，第一个是没有返回值，第二个是不能抛出受检查异常；接下来分析了 Callable 接口，并且把 Callable 接口和 Runnable 接口的区别进行了对比和总结。






