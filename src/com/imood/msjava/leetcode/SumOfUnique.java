package com.imood.msjava.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author msJava
 * @Description: 1748. 唯一元素的和
 */
public class SumOfUnique {

    public static int sumOfUnique(int[] nums) {

        if(nums==null){
            return 0;
        }

        int sum=0;

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                sum+=entry.getKey();
            }
        }
        return sum;
    }

}
