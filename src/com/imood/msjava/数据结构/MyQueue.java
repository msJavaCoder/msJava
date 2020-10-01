package com.imood.msjava.数据结构;

import java.util.Stack;

/**
 * @description: 用栈实现队列
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
class MyQueue {


    /**
     * 栈的顺序为后进先出，而队列的顺序为先进先出。
     * 使用两个栈实现队列，一个元素需要经过两个栈才能出队列，在经过第一个栈时元素顺序被反转，
     * 经过第二个栈时再次被反转，此时就是先进先出顺序。
     */
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();


    public void push(int x) {

        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

