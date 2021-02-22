package com.imood.msjava.offer;

/**
 * @author msJava
 * @Description: 剑指 Offer 57. 和为s的两个数字
 *
 *      排序数组  和为s的两个数字
 *
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }

        int l1 = 0;
        int l2 = nums.length - 1;

        while (l1 < l2) {
            int sum = nums[l1] + nums[l2];
            if (sum == target) {
                return new int[]{nums[l1], nums[l2]};
            } else if (sum < target) {
                l1++;
            } else {
                l2--;
            }
        }

        return new int[0];


    }


}
