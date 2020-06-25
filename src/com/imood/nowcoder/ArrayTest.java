package com.imood.nowcoder;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/24/0024
 * @version: 1.0
 */
public class ArrayTest {


    /**
     * 删除数组第一个元素，返回新数组
     * @param array
     * @return
     */
    public int[] curtail(int[] array){

         int index=0;
        for (int i =1 ; i < array.length-1; i++) {
               array[index]=array[i];
               index++;
        }




        return array;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4};


        int index=0;
        for (int i =1 ; i < array.length; i++) {
            array[index]=array[i];
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
