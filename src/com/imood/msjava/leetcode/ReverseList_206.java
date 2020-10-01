package com.imood.msjava.leetcode;

/**
 * @description: 链表反转
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class ReverseList_206 {

    /**
     * 递归解决 —— 链表反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

}
