package com.imood.msjava.leetcode;

/**
 * @description: 167. 两数之和 II - 输入有序数组
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class TwoSum_167 {

    /**
     * 题目描述：在有序数组中找出两个数，使它们的和为 target。
     * 思路：
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                //返回数组下标+1
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return null;
    }
}
