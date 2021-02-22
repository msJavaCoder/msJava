package com.imood.msjava.offer;

import com.imood.msjava.leetcode.ListNode;

import java.util.Stack;

/**
 * msJava
 *
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * @Date 2021-02-21
 */
public class ReversePrint06 {

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop().val;
        }
        return array;
    }
}
