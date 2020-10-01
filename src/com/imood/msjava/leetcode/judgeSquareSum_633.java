package com.imood.msjava.leetcode;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class judgeSquareSum_633 {

    /**
     * 题目描述：判断一个非负整数是否为两个整数的平方和。
     * <p>
     * 可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，
     * 如果能找到，则返回 true，表示 target 是两个整数的平方和。\
     * <p>
     * <p>
     * 本题的关键是右指针的初始化，实现剪枝，
     * 从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，
     * 我们可以将 x 取为 sqrt(target)。
     *
     * @param target
     * @return
     */
    public boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int low = 0;
        int high = (int) Math.sqrt(target);

        while (low <= high) {

            int powSum = low * low + high * high;
            if (powSum == target) {
                return true;
            } else if (target < powSum) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
