package com.bala.longestSubString;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==1||s.length()==0) return s.length();
        boolean[] chars = new boolean[128];
        chars[s.charAt(0)] = true;
        int start = 0;
        int end = 1;
        int max = 1;
        while (end<s.length()){
            if (chars[s.charAt(end)]){
                max = Math.max(end-start,max);
                while (start<end) {
                    if (s.charAt(start)!=s.charAt(end)) {
                        chars[s.charAt(start)] = false;
                        start++;
                    }
                    else {
                        start++;
                        break;
                    }
                }
            }
            else
                chars[s.charAt(end)]=true;
            end++;
        }
        return Math.max(max,end-start);
    }

    public int lengthOfLongestSubstring2(String s){//用hashmap
        int left = 0;
        int ans = 0;
        int end = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (end<s.length()) {
            if (map.containsKey(s.charAt(end))&&left<=map.get(s.charAt(end))){
                ans = Math.max(ans,end-left);
                left = map.get(s.charAt(end))+1;
            }
            map.put(s.charAt(end),end);
            end++;
        }
        return Math.max(ans, end - left);
    }
    public int lengthOfLongestSubstring3(String s){//用数组
        int left = 1, right = 1,ans = 0;
        int[] index = new int[128];
        while (right-1<s.length()){
            char c = s.charAt(right-1);
            if (index[c]>=left){
                ans = Math.max(ans, right-left);
                left = index[c] + 1;
            }
            index[c] = right;
            right++;
        }
        return Math.max(ans, right-left);
    }

    /**
     * leetcode No.32
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length()==1||s.length()==0) return 0;
       int[] dp = new int[s.length()];
       dp[1] = (s.charAt(0)=='('&&s.charAt(1)==')')? 2:0;
       int ans = dp[1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    dp[i] = dp[i-2]+2;
                }else {
                    if (dp[i-1]!=0&&i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='(')
                        dp[i] = dp[i-1]+2+(i-dp[i-1]-2)>=0?dp[i-dp[i-1]-2]:0;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
