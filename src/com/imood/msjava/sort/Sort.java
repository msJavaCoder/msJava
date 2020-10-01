package com.imood.msjava.sort;


/**
 * @description: 常見排序算法
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/21/0021
 * @version: 1.0
 */
public class Sort {

    /**
     * 冒泡排序算法 时间复杂度 N2 空间复杂度 1 稳定
     *
     * @param array
     * @return
     */
    public static void bubbleSort(int[] array) {
        //外循环控制循环比较次数
        for (int i = 1; i < array.length; i++) {
            //内循环控制比较元素，针对待排序元素
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    //元素交换位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序算法优化 时间复杂度 N2 空间复杂度 1 稳定
     * 在第一层循环内加一个判断标识，每次赋值为 true，
     * 假如在第二层循环（内层循环）时执行了位置交换，也就是 if 中的代码之后，
     * 我们把此值设置成 false；如果执行完内层循环判断之后，变量依然为 true，
     * 这就说明没有可以移动的元素了，冒泡排序可以结束执行了
     *
     * @param array
     */
    public static void bubbleSortPLus(int[] array) {
        //外循环控制循环比较次数
        for (int i = 1; i < array.length; i++) {

            boolean flag = true;
            //内循环控制比较元素，针对待排序元素
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    //元素交换位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
                if (flag) {
                    break;
                }
            }
        }
    }


    /**
     * 插入排序算法 时间复杂度 N ~ N2 （时间复杂度与初始排序状态有关） 空间复杂度 1 稳定
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //插入的元素
            int inserVal = array[i];
            //被插入的位置（准备和前一个数进行比较）
            int index = i - 1;
            //如果插入的元素比被插入的数小
            while (index >= 0 && inserVal < array[index]) {
                //则将array[index]向后移动
                array[index + 1] = array[index];
                //将index向后移动
                index--;
            }
            //将插入的元素放入合适的位置
            array[index + 1] = inserVal;
        }
        return array;
    }


    /**
     * 选择排序算法 时间复杂度 N2 空间复杂度 1 不稳定
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //记录最小元素
            int min = array[i];
            //记录最小元素位置
            int minIndex = i;
            //在未排序数组中找到最小元素和对应位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            //元素交换位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 希尔排序 时间复杂度 N 的若干倍乘于递增序列的长度  ， 空间复杂度 1   不稳定
     * -----改进版插入排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        return array;
    }


    /**
     * 快速排序算法 时间复杂度 NlogN 空间复杂度 logN 不稳定
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            quickSort(array, 0, index - 1);
            quickSort(array, index + 1, high);
        }
        return array;
    }

    //快速排序分区操作
    private static int partition(int[] array, int low, int high) {
        //1.找一个基准值
        int pivot = array[low];
        //2.当low 小于 high 重复操作
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            //从low开始，如果low小于pivot, low++ ,否则 low 的值直接赋值给 high
            while ((low < high) && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        //3.最后基准值
        array[low] = pivot;
        //4.返回基准值位置
        return low;
    }

    /**
     * 二分查找算法 - 前提数组升序 ，如果是降序 就把向右查找的条件换成 target<array[mid] 就可以了
     *
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (array[mid] == target) {
                return mid;
            } else if (target > array[mid]) {  //向右查找
                low = mid + 1;
            } else { //向左查找
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 归并排序 时间复杂度NlogN 空间复杂度N  稳定
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }


    /**
     * 对左右两边的数据进行递归
     *
     * @param array
     * @param left
     * @param right
     */
    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            return;
        }
        //中间索引
        int center = (left + right) / 2;
        //对左边的数组递归排序
        sort(array, left, center);
        //对右边的数组递归排序
        sort(array, center + 1, right);
        //将两边数组进行归并
        merge(array, left, center, right);
    }

    private static void merge(int[] array, int left, int center, int right) {

        //todo
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};


    }


}
