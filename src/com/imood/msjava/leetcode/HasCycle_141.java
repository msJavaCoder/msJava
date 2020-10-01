package com.imood.msjava.leetcode;

/**
 * @description:判断链表是否存在环
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class HasCycle_141 {
    /**
     * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode low = head;
        ListNode high = head.next;

        while (low != null && high != null && high.next != null) {
            if (low == high) {
                return true;
            }
            low = low.next;
            high = high.next;
        }
        return false;
    }
}
