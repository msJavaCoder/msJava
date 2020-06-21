package com.imood.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/19/0019
 * @version: 1.0
 */
public class Test_01 {


    /**
     * 在一数组中找到任意一个重复元素
     * @param array
     * @return
     */
    public static boolean findElementInArray(int[] array){

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(set.contains(array[i])){
                return true;
            }else {
                set.add(array[i]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr={2,3,1,0,2,5};
        boolean elementInArray = Test_01.findElementInArray(arr);
        System.out.println(elementInArray);

    }
}
