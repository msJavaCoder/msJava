package com.imood.msjava.leetcode.链表问题;

import com.imood.msjava.leetcode.ListNode;

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
    public ListNode reverseList_01(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList_01(next);
        next.next = head;
        head.next = null;
        return newHead;
    }


    public ListNode reverseList_02(ListNode head) {
        ListNode first = head;
        ListNode reverseHead = null; //建立一个新的节点用来存放结果
        while (first != null) { //遍历输入链表，开始处理每一个节点
            ListNode second = first.next; //先处理第一个节点first，所以需要一个指针来存储first的后继
            first.next = reverseHead; //将first放到新链表头节点的头部
            reverseHead = first; //移动新链表的头指针，让它始终指向新链表头部
            first = second; //继续处理原链表的节点，即之前指针存放的后继，循环往复
        }
        return reverseHead;

    }
}
