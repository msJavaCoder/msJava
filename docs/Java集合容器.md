# Java集合容器

> Java集合容器包括Collection和Map两种，Collection存储着对象的集合，而Map存储着键值对的映射表。

## 1. Collection

### 1.1 Set

+ TreeSet ：基于红黑树实现，支持有序性操作，如根据范围查找元素的操作，但是查询效率不如HashSet,HashSet查找的时间复杂度为O(1),TreeSet 为O（logN)。
+ HashSet ：基于哈希表实现，支持快速查找， 但不支持有序操作，并且失去了元素的插入顺序信息，也就是说明Iterator遍历HashSet得到的结果是不确定的。
+ LinkedHashSet ：具有HashSet的查询效率，并且内部使用双向链表维护元素的插入顺序。

### 1.2 List

+ ArrayList ： 基于动态数组实现，支持随机访问。
+ Vertor ： 和ArrayList 类似，但是它是线程安全的。
+ LinkedList ： 基于双向链表实现，只能顺序访问，但是可以快速地在链表中间插入和删除元素。不仅如此，LinkedList还可以用作栈、队列和双向队列。

### 1.3 Queue

+ LinkedList ： 可以用它来实现双向队列。
+ PriortyQueue  ： 基于堆结构实现，可以用它来实现优先队列。

## 2 .Map

+ TreeMap ： 基于红黑树实现。
+ HashMap  ： 基于哈希表实现。
+ HashTable ： 和HashMap  类似，但它是线程安全的。
+ LinkedHashMap ： 使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用顺序。

