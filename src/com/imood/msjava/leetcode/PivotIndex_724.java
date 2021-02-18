package com.imood.msjava.leetcode;

/**
 * @author msJava
 * @Description: todo
 */
public class PivotIndex_724 {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 2) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int lefSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lefSum == sum - lefSum - nums[i]) {
                return i;
            }
            lefSum+=nums[i];
        }
        return -1;
    }
}
