package com.imood.msjava.leetcode;

import java.util.Stack;

/**
 * @description: 用栈实现括号匹配
 * @author: 微信公众号：码上Java
 * @createDate: 2020/7/29/0029
 */
public class IsValid_20 {


    /**
     * 用栈实现括号匹配
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
