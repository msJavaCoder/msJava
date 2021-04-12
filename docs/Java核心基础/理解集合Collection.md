## 理解集合Collection

​		先来看看集合的继承关系图，如下图所示：

![enter image description here](https://images.gitbook.cn/ae489970-ca62-11e9-bd50-998f3938aecb)

其中：

- 外框为虚线的表示接口，边框为实线的表示类；
- 箭头为虚线的表示实现了接口，箭头为实线的表示继承了类。

为了方便理解，我隐藏了一些与本文内容无关的信息，隐藏的这些内容会在后面的章节中进行详细地介绍。

从图中可以看出，集合的根节点是 Collection，而  Collection 下又提供了两大常用集合，分别是：

- List：使用最多的有序集合，提供方便的新增、修改、删除的操作；
- Set：集合不允许有重复的元素，在许多需要保证元素唯一性的场景中使用。

下面我们分别对集合类进行详细地介绍。

### List ：可重复

> List是一个非常常用的数据类型，一共有以下三种实现类，分别为：**Vector 、ArrayList、LinkedList** 。

#### Vector

​		Vector内部是基于数组实现，**线程安全**（synchronized关键字），也就是说在同一个时刻只能允许一个线程对Vector进行写操作，以保证在多线程环境下数据的一致性，但是频繁的进行加锁和释放锁操作，会导致Vector的**读写效率比较底** 。

#### ArrayList

​		ArrayList使用非常广泛，内部也是基于**数组**实现，**线程不安全**，ArrayList**不适合随机插入和删除的操作**，更**适合随机查找和遍历的操作**。

#### LinkedList

​		LinkedList采用**双向链表**结构存储元素，**随机插入和删除效率高**，**随机访问的效率低**。

### Set : 不可重复

> Set 的核心价值观就是独一无二，适合存储无序且值不相等的元素。对象的相等性本质上就是对象的HashCode值相等，在Java中根据对象的内存地址计算的对象的HashCode值。如果想要比较两个对象是否相等，则必然同时覆盖对象的hashCode方法和equals方法，并且hashCode方法和equals方法的返回值也必须一样。

#### HashSet

​		HashSet 是一个**没有重复元素**的集合，存放的是散列值，它按照元素的散列值来存取元素的。元素的散列值是通过元素的hashCode方法计算得到的，HashSet 首先判断两个元素的散列值是否相等，如果散列值相等，在用equals方法比较，如果equals也返回true，则是同一个元素，否则就不是同一个元素。虽然它是 Set 集合的子类，**基于 HashMap 的实现，**相关源码如下：

```java
public HashSet() {
    map = new HashMap<>();
}
```

因此 HashSet 是**无序**集合，没有办法保证元素的顺序性。

**HashSet 默认容量为 16，每次扩充 0.75 倍**，相关源码如下：

```java
public HashSet(Collection<? extends E> c) {
    map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
    addAll(c);
}
```

#### TreeSet

​		TreeSet 基于二叉树的原理对新添加的对象按照指定的顺序排序，每添加一个对象都会进行排序 ，并将对象插入二叉树的指定位置。

#### LinkedHashSet

​		LinkedHashSet 继承HashSet，HashMap实现数据存储，双向链表记录顺序。LinkedHashSet 底层使用的LinkedHashMap存储元素，它继承了HashMap。

### Quenue

​		Quenue是队列结构，Java中的常用队列如下：

- ArrayBlockingQueue : 基于数组数据结构实现的有界阻塞队列。
- LinkedBlockingQueue : 基于链表数据结构实现的有界阻塞队列。
- PriorityBlockingQueue : 支持优先级排序的无界阻塞队列。
- DelayQueue : 支持延迟操作的无界阻塞队列。
- SynchronousQueue : 用于线程同步的阻塞队列。
- LinkedTransferQueue : 基于链表数据结构实现的无界阻塞队列。
- LinkedBlockingDeque : 基于链表数据结构实现双向阻塞队列。 吧

### 相关面试题

#### 1.List 和 Set 有什么区别？

答：区别分为以下几个方面：

- List 允许有多个 null 值，Set 只允许有一个 null 值；
- List 允许有重复元素，Set 不允许有重复元素；
- List 可以保证每个元素的存储顺序，Set 无法保证元素的存储顺序。

#### 2.哪种集合可以实现自动排序？

答：TreeSet 集合实现了元素的自动排序，也就是说无需任何操作，即可实现元素的自动排序功能。

#### 3.Vector 和 ArrayList 初始化大小和容量扩充有什么区别？

答：Vector 和 ArrayList 的默认容量都为 10，源码如下。

Vector 默认容量源码：

```java
public Vector() {
    this(10);
}
```

ArrayList 默认容量源码：

```java
private static final int DEFAULT_CAPACITY = 10;
```

Vector 容量扩充默认增加 1 倍，源码如下：

```java
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                     capacityIncrement : oldCapacity);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

其中 capacityIncrement 为初始化 Vector 指定的，默认情况为 0。

ArrayList 容量扩充默认增加大概 0.5 倍（oldCapacity + (oldCapacity >> 1)），源码如下（JDK 8）：

```java
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

#### 4.Vector、ArrayList、LinkedList 有什么区别？

答：这三者都是 List 的子类，因此功能比较相似，比如增加和删除操作、查找元素等，但在性能、线程安全等方面表现却又不相同，差异如下：

- Vector 是 Java 早期提供的动态数组，它使用 synchronized 来保证线程安全，如果非线程安全需要不建议使用，毕竟线程同步是有性能开销的；
- ArrayList 是最常用的动态数组，本身并不是线程安全的，因此性能要好很多，与 Vector 类似，它也是动态调整容量的，只不过 Vector 扩容时会增加 1 倍，而 ArrayList 会增加 50%；
- LinkedList 是双向链表集合，因此它不需要像上面两种那样调整容量，它也是非线程安全的集合。

#### 5.Vector、ArrayList、LinkedList 使用场景有什么区别？

答：Vector 和 ArrayList 的内部结构是以数组形式存储的，因此非常适合随机访问，但非尾部的删除或新增性能较差，比如我们在中间插入一个元素，就需要把后续的所有元素都进行移动。

LinkedList 插入和删除元素效率比较高，但随机访问性能会比以上两个动态数组慢。

#### 6.Collection 和 Collections 有什么区别？

答：Collection 和 Collections 的区别如下：

- Collection 是集合类的上级接口，继承它的主要有 List 和 Set；
- Collections 是针对集合类的一个帮助类，它提供了一些列的静态方法实现，如 Collections.sort() 排序、Collections.reverse() 逆序等。

#### 7.以下选项没有继承 Collection 接口的是？

A：List
B：Set
C：Map
D：HashSet

答：C

#### 8.LinkedHashSet 如何保证有序和唯一性？

答：LinkedHashSet 底层数据结构由哈希表和链表组成，链表保证了元素的有序即存储和取出一致，哈希表保证了元素的唯一性。

#### 9.HashSet 是如何保证数据不可重复的？

答：HashSet 的底层其实就是 HashMap，只不过 HashSet 实现了 Set 接口并且把数据作为 K 值，而 V 值一直使用一个相同的虚值来保存，我们可以看到源码：

```java
public boolean add(E e) {
    return map.put(e, PRESENT)==null;// 调用 HashMap 的 put 方法,PRESENT 是一个至始至终都相同的虚值
}
```

由于 HashMap 的 K 值本身就不允许重复，并且在 HashMap 中如果 K/V 相同时，会用新的 V 覆盖掉旧的 V，然后返回旧的 V，那么在 HashSet 中执行这一句话始终会返回一个 false，导致插入失败，这样就保证了数据的不可重复性。

#### 10.执行以下程序会输出什么结果？为什么？

```java
Integer num = 10;
Integer num2 = 5;
System.out.println(num.compareTo(num2));
```

答：程序输出的结果是 `1`，因为 Integer 默认实现了 compareTo 方法，定义了自然排序规则，所以当 num 比 num2 大时会返回 1，Integer 相关源码如下：

```java
public int compareTo(Integer anotherInteger) {
    return compare(this.value, anotherInteger.value);
}
public static int compare(int x, int y) {
    return (x < y) ? -1 : ((x == y) ? 0 : 1);
}
```

#### 11.如何用程序实现后进先出的栈结构？

答：可以使用集合中的 Stack 实现，Stack 是标准的后进先出的栈结构，使用 Stack 中的 pop() 方法返回栈顶元素并删除该元素，示例代码如下。

```java
Stack stack = new Stack();
stack.push("a");
stack.push("b");
stack.push("c");
for (int i = 0; i < 3; i++) {
    // 移除并返回栈顶元素
    System.out.print(stack.pop() + " ");
}
```

程序执行结果：`c b a`

#### 12.LinkedList 中的 peek() 和 poll() 有什么区别？

答：peek() 方法返回第一个元素，但不删除当前元素，当元素不存在时返回 null；poll() 方法返回第一个元素并删除此元素，当元素不存在时返回 null。

#### 13.Comparable 和 Comparator 有哪些区别？

答：Comparable 和 Comparator 的主要区别如下：

- Comparable 位于 java.lang 包下，而 Comparator 位于 java.util 包下；
- Comparable 在排序类的内部实现，而 Comparator 在排序类的外部实现；
- Comparable 需要重写 CompareTo() 方法，而 Comparator 需要重写 Compare() 方法；
- Comparator 在类的外部实现，更加灵活和方便。

### 总结

本文介绍的集合都实现自 Collection，因此它们都有同样的操作方法，如 add()、addAll()、remove() 等，Collection 接口的方法列表如下图：

![img](https://images.gitbook.cn/4cfddf30-ca63-11e9-bd50-998f3938aecb)

当然部分集合也在原有方法上扩充了自己特有的方法，如 LinkedList 的 offer()、push() 等方法。本文也提供了数组和集合互转方法，List.toArray() 把集合转换为数组，Arrays.asList(array) 把数组转换为集合。最后介绍了 Comparable 和 Comparator 的使用和区别，Comparable 和 Comparator 是 Java 语言排序提供的两种排序方式，Comparable 位于 java.lang 包下，如果一个类实现了 Comparable 接口，就意味着该类有了排序功能；而 Comparator 位于 java.util 包下，是一个外部比较器，它无需在比较类中实现 Comparator 接口，而是要新创建一个比较器类来进行比较和排序。