package com.imood.hashMap;


import java.util.*;

/**
 * @description:  HashMap
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/23/0023
 * @version: 1.0
 */
public class TestMap {


    public static void main(String[] args) {



    }

    public static void getMap(Map<Integer,String> hashMap){
       /* for (Object key: hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }*/
   /*     for (Object v: hashMap.values()) {
            System.out.println(v);
        }
*//*
        for (Map.Entry<Integer,String> entry: hashMap.entrySet() ) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }*/

        /**
         *
         * 利用迭代器Iterator 遍历map
         */
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey()+","+entry.getValue());
        }

    }




    public static Map<Integer,String> inputMap(){
       Map<Integer, String> hashMap = new HashMap<>();
       hashMap.put(1,"xiaoming");
       hashMap.put(2,"xiaohong");
       hashMap.put(3,"xiaozhang");
       hashMap.put(4,"xiaopang");
       hashMap.put(5,"xiaoli");
       hashMap.put(6,"xiaoszi");
       return hashMap;
    }
}
