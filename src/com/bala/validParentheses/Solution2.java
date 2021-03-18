package com.bala.validParentheses;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int longestValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty()){
                    stack.pop();
                    temp+=2;
                }else {
                    max = Math.max(temp, max);
                    temp = 0;
                }
            }
        }
        return Math.max(temp,max);
    }
}
