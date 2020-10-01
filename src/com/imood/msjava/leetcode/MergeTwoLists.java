package com.imood.msjava.leetcode;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/2/0002
 */
public class MergeTwoLists {


    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newHead = null;

        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}




