package com.imood.msjava;

import java.util.*;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */

public class Main {

    public static void main(String args[]){

         Map<Integer,Integer> map=new HashMap<>();
         map.put(1,2);
         map.put(2,3);
         map.put(3,4);
         map.put(4,5);
        for (Integer key:map.keySet()) {
            System.out.println(key+" : "+ map.get(key));
        }

    }
}
