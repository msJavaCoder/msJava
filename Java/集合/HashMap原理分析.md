# HashMap
## 1. HashMap底层原理
> JDK1.7 中HashMap是数组+链表的形式组成， 
> JDK1.8 中HashMap是数组+链表或红黑树的形式组成。当链表的长度大于8或者容量大于64，链表结构会转换为红黑树结构。
> 哈希桶包含四个字段：hash、key、value、next 
> 添加红黑树的原因：当链表过长的时候，会严重影响HashMap的性能，而红黑树具有快速增删改查的特点，可以有效解决链表过长时导致的问题。
1. JDK1.8 HashMap扩容时做了哪些优化？
2. 加载因子为什么时0.75？
3. 当有哈希冲突时，HashMap是如何查找并确定元素的？
4. HashMap源码中有哪些重要方法？
5. HashMap是如何导致死循环的？

### 1.1 HashMap源码分析（JDK1.8）
HashMap 源码中包含了以下几个属性：
```java
// HashMap 初始化长度
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
// HashMap 最大长度
static final int MAXIMUM_CAPACITY = 1 << 30; // 1073741824
// 默认的加载因子 (扩容因子)
static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 当链表长度大于此值且容量大于 64 时
static final int TREEIFY_THRESHOLD = 8;
// 转换链表的临界值，当元素小于此值时，会将红黑树结构转换成链表结构
static final int UNTREEIFY_THRESHOLD = 6;
// 最小树容量
static final int MIN_TREEIFY_CAPACITY =64
```

**什么是加载因子？加载因子为什么是 0.75？**

> 加载因子也叫扩容因子或负载因子，用来判断什么时候进行扩容的，假如加载因子是 0.5，HashMap 的初始化容量是 16，那么当 HashMap 中有 16*0.5=8 个元素时，HashMap 就会进行扩容。
>
> 那加载因子为什么是 0.75 而不是 0.5 或者 1.0 呢？
>
> 这其实是出于容量和性能之间平衡的结果：
>
> 当加载因子设置比较大的时候，扩容的门槛就被提高了，扩容发生的频率比较低，占用的空间会比较小，但此时发生 Hash 冲突的几率就会提升，因此需要更复杂的数据结构来存储元素，这样对元素的操作时间就会增加，运行效率也会因此降低；
> 而当加载因子值比较小的时候，扩容的门槛会比较低，因此会占用更多的空间，此时元素的存储就比较稀疏，发生哈希冲突的可能性就比较小，因此操作性能会比较高。
> 所以综合了以上情况就取了一个 0.5 到 1.0 的平均数 0.75 作为加载因子。

