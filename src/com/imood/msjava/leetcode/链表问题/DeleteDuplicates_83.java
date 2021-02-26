package com.imood.msjava.leetcode.链表问题;

import com.imood.msjava.leetcode.ListNode;

/**
 * @author msJava
 * @Description: 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates_83 {

    public ListNode deleteDuplicates(ListNode head){
        ListNode temp=head;
        while (temp!=null){
            // 一个元素  不可能重复
            if(temp.next==null){
                break;
            }
            // 因为链表是已经排序好的，重复元素必定连续 所有就是判断当前节点与下一个节点的值是否相等就行了，相等就有重复 删除即可
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return head;
    }
}
