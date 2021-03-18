package com.bala.validParentheses;

import com.bala.list.removeNthListNode.ListNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    使用栈解决
     */
    public static boolean isValid(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Deque<Character> deque = new LinkedList<>();//创建一个栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='{'||c=='['||c=='(')
                deque.push(c);
            else if (c=='}'||c==']'||c==')'){
                if (deque.isEmpty()) return false;
                char cur = deque.pop();
                if (cur!=map.get(c)) return false;
            }
        }
        return deque.isEmpty();
    }

    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * Example 1:
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * Example 2:
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {//
        if (s.length()<2) return 0;
        int[] dp = new int[s.length()];
        dp[1] = s.substring(0, 2).equals("()") ?2:0;
        int max = dp[1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='(')
                    dp[i] = dp[i-2] + 2 ;
                if (s.charAt(i-1)==')'&&i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='(')
                    dp[i] = dp[i-1]+2+dp[Math.max(i - dp[i - 1] - 2, 0)];
                max = Math.max(max,dp[i]);
            }
        }
        return  max;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
            iter.next = new ListNode(sum%10);
            iter = iter.next;
            carry = sum / 10;
            if (l1!=null) l1= l1.next;
            if (l2!=null) l2 = l2.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        System.out.println(isValid("(){}{[[]]}"));
    }


}
