package com.imood.msjava.leetcode.双指针解法;


/**
 * @author msJava
 * @Description: 给定一个链表，判断链表中是否有环。
 *    思路： 使用快慢双指针，链表中存在环的话，双指针必定会相遇
 */
public class HasCycle_141 {

    public Boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }

        ListNode node1=head;
        ListNode node2=head.next;

        while(node1!=null &&node2!=null && node2.next!=null){
            if(node1==node2){
                return true;
            }
            node1=node1.next;
            node2=node2.next.next;
        }

        return false;


    }
}
