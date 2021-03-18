package com.bala.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        helper(list, "", 0, 0, n);
        return list;

    }
    private void helper(List<String> list, String s, int leftNum, int rightNum,int n){
        if (rightNum==n) {
            list.add(s);
            return;
        }
        if (leftNum<n)
        helper(list,s+"(", leftNum+1, rightNum,n);
        if (leftNum>rightNum)
            helper(list, s+")", leftNum, rightNum+1,n);
    }


}
