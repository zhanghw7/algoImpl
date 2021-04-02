package com.bala.dp;

/**
 * @Description leetcode 1808
 * @Author Zhang Hongwei
 * @Date 2021/4/2 10:22
 */
public class MaxNiceDivisorsSolution {
    public int maxNiceDivisors(int primeFactors) {
        return integerBreak(primeFactors);
    }

    //参考343题
    public int integerBreak(int primeFactors){
        long[] dp = new long[primeFactors + 1];//dp[i]代表数字i被拆分后的最大乘积
        for(int i = 1; i <= primeFactors; i++){
            dp[i] = i;
            for (int j = 1; j <= i / 2 ; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return (int) dp[primeFactors]  % 1000000007;
    }
}
