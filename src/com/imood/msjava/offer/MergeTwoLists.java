package com.imood.msjava.offer;

import com.imood.msjava.leetcode.ListNode;

/**
 * @author msJava
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 1. 创建一个虚拟节点
         */
        ListNode dum=new ListNode(0);
        ListNode cur=dum;


        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        /**
         * 返回虚拟节点的下一个节点  就是合并好的头结点
         */
        return dum.next;

    }
}
