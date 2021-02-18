package com.imood.msjava.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author msJava
 * @Description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。  345
 */
public class ReverseVowels_345 {

    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        int low = 0;
        int high = s.length() - 1;
        char[] result = new char[s.length()];
        while (low <= high) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);
            if (!vowels.contains(lowChar)) {
                result[low++] = lowChar;
            } else if (!vowels.contains(highChar)) {
                result[high--] = highChar;
            } else {
                result[low++] = highChar;
                result[high--] = lowChar;
            }
        }
        return new String(result);
    }
}
