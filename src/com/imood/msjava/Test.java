package com.imood.msjava;

/**
 * @description:
 * @author: msJava
 * @createDate: 2020/07/02
 * @version: 1.0
 */
public class Test {

    /**
     * 输入单链表的倒数第N个元素
     *
     * @param head
     * @param N
     * @return
     */
    public int kthToLast(ListNode head, int N) {
        //双指针法

        int a;
        ListNode pre = head;
        ListNode low = head;
        if (head.next == null) {
            return head.val;
        }
        //先让pre在单链表上走N步，然后两个一起走，
        // pre到链表尾部时，low刚好位于链表倒数第N个节点上，直接返回该节点即可
        for (int i = 0; i < N; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            low = low.next;
        }
        return low.val;

    }

    /**
     * 单链表实体
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
