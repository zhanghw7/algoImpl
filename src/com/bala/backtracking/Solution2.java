package com.bala.backtracking;

import java.awt.image.BandedSampleModel;

public class Solution2 {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Note: Given n will be a positive integer.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int climbStairs(int n) {//这种方法会溢出
        if (n==0) return 0;
        return helper(n, 0, 0);
    }

    public int helper(int n, int cur, int ans) {
        if (cur == n) {
            ans++;
            return ans;
        }
        if (cur > n)
            return ans;
        return helper(n, cur + 2, helper(n, cur + 1, ans));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        if (n==0||n==1||n==2) return n;
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 2;
        int ans = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

