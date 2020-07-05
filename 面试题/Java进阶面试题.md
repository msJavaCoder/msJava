# Java面试题

## 1. 基础面试题

**1.1  “String、StringBuffer、StringBulider”的区别是什么？**

> 1.可变性。String不可变，StringBuffer与StringBulider可变。
>
> + String类是使用字符祖保存字符串，private final char value[]，所有不可变的（Java9中底层把char数组换成了byte数组，占用更少的空间。
> + StringBulider与StringBuffer都继承自AbstractStringBulider类，在AbstractStringBulider中也是使用字符串组保存字符串，char[] value，这两种对象都是可变的。
>
> 2.线程安全。StringBulider是非线程安全的，String和StringBuffer是线程安全的。
>
> + String线程安全是因为其对象不可变，StringBuffer线程安全是因为对方法加了同步锁或者调用的方法加了同步锁。
> + StringBulider并没有对方法进行加同步锁，所以是非线程安全的。
>
> 3.性能。
>
> + String的性能较差，每次对String类型进行改变的时候，都会生成一个新的String对象，然后将引用指向新的String对象。
> + 而StringBulider、StringBuffer性能更高，是因为每次都是对对象本身进行操作，而不是生成新的对象并改变对象引用。

**2.2 “抽象类和接口有什么异同？”**

> 1.相同点
>
> + 不能直接实例化。如果要实例化，抽象类变量必须实现所有抽象方法，接口变量必须实现所有接口未实现的方法。
> + 都可以有实现方法（Java8以前的接口是不能有实现方法的）。
> + 都可以不需要实现类或者继承者去实现所有方法。
>
> 2.不同点
>
> + 抽象类和接口的设计理念不同。抽象类表示的是对象、类的抽象，接口表示的是对行为的抽象。
> + 接口可以多继承，抽象类不可以多继承。即一个类只能继承一个抽象类，却可以继承多个接口。
> + 接口没有构造器，抽象类可以有构造器。
> + 访问修饰符不同
>   + 抽象类中的方法可以用public protected和default abstract 修饰符，不能有private、static、synchronize、native修饰；变量可以在子类中重新定义，也可以重新赋值。
>   + 接口的方法默认修饰符是public abstract，Java8开始出现静态方法，多加static关键字；变量默认是public static final型，且必须给其初始值，在其实现类中也不能重新定义，也不能修改。

**2.3 "Java创建对象的方式有哪些？"**

> 1.使用new关键字；
>
> 2.反射，使用java.lang.Class类的newInstance方法；
>
> 3.反射，使用java.lang.reflect.Constructor类的newInstance方法。
>
> 4.使用clone方法。实现Cloneable接口且实现clone方法。
>
> 4.使用反序列化。

**2.4 “什么是浅拷贝和深拷贝？”**

> + 浅拷贝：被复制对象的所有变量都含有与原来的对象相同的值，对拷贝后对象的引用仍然指向原来的对象。
> + 深拷贝：不仅要复制对象的所有非引用成员变量值，还要为引用类型的成员变量创建新的实例，并且初始化为形式参数实例值。



