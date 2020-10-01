package com.imood.msjava.数据结构;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/18/0018
 */
public class Stack<E> {

    private Object[] data = null;
    private int maxSize = 0;  //栈容量
    private int top = -1;  //栈顶指针

    // 初始化构造方法
    Stack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0: " + initialSize);
        }
    }

    // 初始化构造方法 默认栈容量为10
    Stack() {
        this(10);
    }

    //入栈操作

    public boolean push(E e) {
        //首先判断一下栈是否已经满了
        if (top == maxSize - 1) {
            //todo 扩容操作
            throw new RuntimeException("栈已满，元素无法入栈");
        } else {
            data[top] = e;
            top++;
            return true;
        }
    }

    //出栈操作
    public E pop() {
        //首先查看一下栈是否为空
        if (top == -1) {
            throw new RuntimeException("栈为空          ");
        } else {
            //将栈顶元素返回后维护一下栈顶指针
            return (E) data[top--];
        }
    }

    //查看栈顶元素
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空          ");
        } else {
            // 查看栈顶元素并不移除所以说不需要维护栈顶指针
            return (E) data[top];
        }
    }


    public boolean isEmpty() {
        return maxSize == 0;
    }


}
