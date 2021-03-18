package com.bala.regularExpressionMatching;

import java.util.*;

public class Solution {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];//dp[i][j]代表长度为i的字符串和长度为j匹配规则的匹配情况
        dp[0][0] = true;
        for(int i = 2;i <= p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1;i <=s.length();i++)
            for(int j = 1;j <= p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.')
                        dp[i][j] = dp[i-1][j]||dp[i][j-2]||dp[i-1][j-2];//匹配 0 个，1 个和 多个
                    else
                        dp[i][j] = dp[i][j-2];
                }
            }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {

    }

}
