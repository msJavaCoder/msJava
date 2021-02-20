package com.imood.msjava.offer;


import java.util.Stack;

/**
 * @author msJava
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue(){
        in=new Stack<Integer>();
        out=new Stack<Integer>();
    }
    public void appendTail(int value) {
       in.push(value);
    }

    public int deleteHead() {

        if(out.isEmpty()){
            return -1;
        }

        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }


}
