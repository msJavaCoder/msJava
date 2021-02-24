package com.imood.msjava.sort;

/**
 * @author msJava
 * @Description: 快速排序-双边循环
 */
public class QuickSort {

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex=partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);

    }
    public static int partition(int[] arr,int startIndex,int endIndex){

        int pivot=arr[startIndex];
        int left=startIndex;
        int right=endIndex;

        while (left!=right){

            while (left<right && arr[right]>pivot){
                right--;
            }
            while (left<right && arr[left]<=pivot){
                left++;
            }
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            arr[startIndex]=arr[left];
            arr[left]=pivot;
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr={2,12,5,8,7,9,8};
        quickSort(arr,0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
