package com.imood.msjava;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/16/0016
 */
public class Solution {


    public int[] func1(int order_list[][], int n) {

        if (order_list.length == 0 || n == 0) {
            return null;
        }
        //临时数组 义n+1行*2列数组
        int[][] temp = new int[n + 1][2];
        //外循环，定位第i个一维数组
        for (int i = 0; i < order_list.length; i++) {
            for (int j = order_list[i][0]; j <= order_list[i][1]; j++) {
                //内循环从一维数组的第1列遍历到第2列，
                temp[j][0] = j;
                temp[j][1] += order_list[i][2];
            }
        }
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp[i][1];
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] order_list = {{2, 4, 10}, {0, 3, 15}, {3, 4, 21}};
        int n = 6;
        int[] result = new int[n];
        Solution S = new Solution();
        result = S.func1(order_list, n);
        for (int i = 0; i < n + 1; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
