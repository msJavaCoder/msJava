

# JMM保证

如下图所示，来看 JMM 如何保证原子性、可见性，有序性。

​    <img src="http://s0.lgstatic.com/i/image2/M01/8A/BB/CgoB5l14lumAex05AAB83iBktjQ024.png" alt="img" style="zoom: 50%;" />

**原子性**
JMM 保证对除 long 和 double 外的基础数据类型的读写操作是原子性的。另外关键字 synchronized 也可以提供原子性保证。synchronized 的原子性是通过 Java 的两个高级的字节码指令 monitorenter 和 monitorexit 来保证的。

**可见性**
JMM 可见性的保证，一个是通过 synchronized，另外一个就是 volatile。volatile 强制变量的赋值会同步刷新回主内存，强制变量的读取会从主内存重新加载，保证不同的线程总是能够看到该变量的最新值。

**有序性**
对有序性的保证，主要通过 volatile 和一系列 happens-before 原则。volatile 的另一个作用就是阻止指令重排序，这样就可以保证变量读写的有序性。 

happens-before 原则包括一系列规则，如：

1. 程序顺序原则，即一个线程内必须保证语义串行性；

2. 锁规则，即对同一个锁的解锁一定发生在再次加锁之前；

3. happens-before 原则的传递性、线程启动、中断、终止规则等。