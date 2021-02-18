package com.imood.msjava.leetcode.双指针解法;

/**
 * @author msJava
 * @Description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。  680
 */
public class ValidPalindrome_680 {


    /**
     * 判断字符串删除一个字符时是否能够变成回文字符串
     *        左边 右边 都可以删
     * @param s
     * @return
     */
    public boolean validPalindrome(String s){
        for (int i = 0 ,j=s.length()-1; i <j ; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }






    /**
     * 判断字符串是否是回文字符串
     * @param s
     * @param i
     * @param j
     * @return
     */
    public Boolean isPalindrome(String s, int i, int j) {
        if(s==null){
            return false;
        }
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
