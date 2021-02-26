package com.imood.msjava.leetcode.链表问题;

import com.imood.msjava.leetcode.ListNode;

import java.util.*;


/**
 * @author msJava
 * @Description: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 *
 */
public class DeleteDuplicates_82 {


    public ListNode deleteDuplicates(ListNode head){

        ListNode temp=head;

       Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();

        while (temp!=null){
            if(temp.next==null){
                break;
            }
            if(!map.containsKey(temp.val)){
                map.put(temp.val,1);
            }else {
                map.put(temp.val,map.get(temp.val)+1);
            }
            temp=temp.next;
        }

       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(entry.getValue()==1){
              list.add(entry.getKey());
           }
       }
        // 排序
        Collections.sort(list);

        // 根据排序的结果 构造新的链表
        ListNode dummy = new ListNode(-1);
        temp = dummy;

        for (Integer x : list){

            


        }

        return head;
    }



}
