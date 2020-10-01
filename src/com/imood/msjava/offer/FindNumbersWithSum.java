package com.imood.msjava.offer;

import java.util.ArrayList;

/**
 * @description: 剑指offer——题解(自解)
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/26/0026
 * @version: 1.0
 */
public class FindNumbersWithSum {

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            if (array[low] + array[high] == sum) {
                result.add(array[low]);
                result.add(array[high]);
                return result;
            } else if (array[low] + array[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int num = 7;

        ArrayList<Integer> integers = new FindNumbersWithSum().findNumbersWithSum(array, num);


        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }

    }


}
