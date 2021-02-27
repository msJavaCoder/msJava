package com.imood.msjava.offer;

/**
 * msJava
 *
 * @Description  剑指 Offer 05. 替换空格
 * @Date 2021-02-27
 */
public class ReplaceSpace {


    public static String replaceSpace(String s){

        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
