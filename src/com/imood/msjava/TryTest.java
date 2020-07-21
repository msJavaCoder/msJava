package com.imood.msjava;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/20/0020
 */
public  class TryTest {
    public static void main(String[] args) {
        int[] nums = new int[]{99,43,120,39,23,73,65,58,32,51,14,24,62,42,80};
        System.out.println(topKMin(nums, nums.length));	//会从大到小输出：[5,4,3,2,1]
    }

    //寻找前k个最小的数--使用大顶堆
    public static List<Integer> topKMin(int[] nums, int k){
        //将大顶堆大小定义为k，并重写类函数
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return b - a;	//大顶堆：参数2-参数1；小顶堆：参数1-参数2
            }
        });
        for(int i=0; i<nums.length; i++){
            if(i<k){
                pq.offer(nums[i]);	//前k个数，直接入堆
            }else if(nums[i]<pq.peek()){	//如果当前元素比堆顶元素小
                pq.poll();	//说明堆顶元素（堆中最大元素）一定不属于前k小的数，出堆
                pq.offer(nums[i]);	//当前元素有可能属于前k小，入堆
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }

}
