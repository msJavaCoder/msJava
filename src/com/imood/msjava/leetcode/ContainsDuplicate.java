package com.imood.msjava;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author msJava
 * @Description: todo
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){

        if(nums==null){
            return false;
        }

        Arrays.sort(nums);
        for (int j = 0; j < nums.length-1; j++) {
            if(nums[j]==nums[j+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        boolean flag = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(flag);

    }
}
