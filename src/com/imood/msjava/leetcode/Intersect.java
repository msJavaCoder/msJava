package com.imood.msjava.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author msJava
 * @Description: todo
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1==null){
            return nums2;
        }

        if(nums2==null){
            return nums1;
        }


        /**
         * 1. 第一步 将两个数组进行排序
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        List<Integer> resultList = new ArrayList<>();
        /**
         * 2.第二步 使用双指针 分别指向两个数组的头部
         *      比较,如果不相等 , 值小的 向前进一步
         *           如果相等 , 缓存这个相等的值
         *           循环结束的条件就是有一方到头了
         */
        for (int i=0,j=0;i<nums1.length && j<nums2.length;){
            if(nums1[i]==nums2[j]){
                resultList.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        int[] array=new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            array[i]=resultList.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
    }
}
