package com.imood.msjava.offer;

import java.util.Arrays;

/**
 * @author msJava
 * @Description: 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums){

        Arrays.sort(nums);
        for (int i=0 ; i<nums.length ; i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
