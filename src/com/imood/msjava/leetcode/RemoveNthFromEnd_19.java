package com.imood.msjava.leetcode;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class RemoveNthFromEnd_19 {

    /**
     * 删除链表的倒数第 n 个节点  双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // 快指针先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        // 快慢指针一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //当fast.next == null 的时候，就到了
        slow.next = slow.next.next;
        return head;
    }

}
