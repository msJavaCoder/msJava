package com.imood.msjava.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/2/0002
 * @version: 1.0
 */
public class RunningSum {


    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * <p>
     * 请返回 nums 的动态和。
     *
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = RunningSum.runningSum(arr);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
