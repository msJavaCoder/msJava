package com.imood.msjava.offer;

import java.util.*;


/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/26/0026
 * @version: 1.0
 */
public class MoreThanHalfNum_Solution {


    /**
     * 题目描述:
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     * @param array
     * @return
     */
    public int moreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if (array == null || array.length == 0) {
            return 0;
        }
        //先将数组排序，思路就是出现次数最多的数一定在中间。
        Arrays.sort(array);

        int mid = array[len / 2];

        int count = 0;  //记录出现次数
        for (int i = 0; i < len; i++) {
            if (array[i] == mid)   //因为分析的中间数肯定是出现次数最多的，所以直接统计次数就好了
                count++;
        }
        if (count > len / 2) {
            return mid;
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 2, 2, 7, 8, 9};
        int i = new MoreThanHalfNum_Solution().moreThanHalfNum_Solution(array);
        System.out.println(i);
    }
}
