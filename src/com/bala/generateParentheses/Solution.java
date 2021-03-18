package com.bala.generateParentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    回溯法
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        helper("", list, 0, 0, n);
        return list;
    }
    public static void helper(String cur,List list,int right, int left,int n){
        if (right==n){
            list.add(cur);
            return;
        }
        if (left<n)
            helper(cur+"(", list, right, left+1,n);
        if (right<left)
            helper(cur+")", list,right+1, left, n );

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}
