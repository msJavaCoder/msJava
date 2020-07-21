package com.imood.msjava;

import java.util.Arrays;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/21/0021
 */
public class HeapSortMin {
    public static void main(String[] args) {
        int[] a = new int[]{99,43,120,39,23,73,65,58,32,51,14,24,62,42,80};
        heapSort(a);//小顶堆
        System.out.println(Arrays.toString(a));
    }

    /**
     * 构造小顶堆
     * @param arr 待调整数组
     * @param size 调整多少
     * @param index 调整哪一个 最后一个叶子节点的父节点开始调整
     */
    public static void minHeap(int arr[], int size, int index) {

        //左子节点
        int leftNode = 2 * index + 1;
        //右子节点
        int rightNode = 2 * index + 2;

        int min = index;//假设自己最小

        //分别比较左右叶子节点找出最小
        if(leftNode < size && arr[leftNode] < arr[min]) {//如果左侧叶子节点小于min则将最小位置换成leftNode并且递归需要限定范围为数组长度，
            min = leftNode;//将最小位置改为左子节点
        }
        if(rightNode < size && arr[rightNode] < arr[min]) {//如果左侧叶子节点小于min则将最小位置换成rightNode
            min = rightNode;//将最小位置改为右子节点
        }
        //如果不相等就需要交换
        if(min != index) {
            int tem = arr[index];
            arr[index] = arr[min];
            arr[min] = tem;
            //如果下边还有叶子节点并且破坏了原有的堆。需要重新调整
            minHeap(arr, size, min);//位置为刚才改动的位置；
        }
    }
    /**
     * 需要将最小的顶部与最后一个交换
     * @param arr
     */
    public static void heapSort(int arr[]) {
        int start = (arr.length - 1)/2;//开始位置最后一个非叶子节点，最后一个叶子节点的父节点
        for(int i = start; i>=0; i--) {
            minHeap(arr, arr.length, i);
        }

        //最后一个跟第一个进行调整
        for(int i = arr.length-1; i > 0; i--) {
            int temp = arr[0];//最前面的一个
            arr[0] = arr[i];//最后一个
            arr[i] = temp;
            //调整后再进行小顶堆调整
            minHeap(arr, i, 0);
        }
    }
}
