package com.imood.jianzhioffer;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/25/0025
 * @version: 1.0
 */
public class Test_02 {

    /**
     *  删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int newLen=0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[newLen]!=nums[i]){
                newLen++;
                nums[newLen]=nums[i];
            }
        }

        return newLen+1;

    }

}
