package com.imood.msjava.leetcode;

/**
 * @description:归并两个有序的链表
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class MergeTwoLists_21 {

    /**
     * 归并两个有序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
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
