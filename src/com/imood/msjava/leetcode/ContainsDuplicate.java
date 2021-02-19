package com.imood.msjava.leetcode;

import java.util.Arrays;

/**
 * @author msJava
 * @Description: 存在重复元素
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){

        if(nums==null){
            return false;
        }

        Arrays.sort(nums);
        for (int j = 0; j < nums.length-1; j++) {
            if(nums[j]==nums[j+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        boolean flag = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(flag);

    }
}
