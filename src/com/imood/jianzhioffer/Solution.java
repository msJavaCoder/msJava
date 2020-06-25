package com.imood.jianzhioffer;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/24/0024
 * @version: 1.0
 */
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1==null||pHead2==null){
            return null;
        }

         int plen1=0;
         int plen2=0;

         while (pHead1!=null){
             plen1++;
         }
         while (pHead2!=null){
             plen2++;
         }

         int flag=plen1-plen2;
         if(flag>0){
             while (flag>0){
                 pHead1=pHead1.next;
                 flag--;
             }
             while (pHead1!=pHead2){
                 pHead1=pHead1.next;
                 pHead2=pHead2.next;
             }
             return pHead1;
         }

        if(flag<=0){
            while (flag<0){
                pHead2=pHead2.next;
                flag++;
            }
            while (pHead1!=pHead2){
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }



        return null;





    }
}
