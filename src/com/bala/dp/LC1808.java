package com.bala.dp;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/22 15:16
 */
public class LC1808 {
    //整数拆分 + 快速幂 + 大数问题；
    private long N = (long) (1e9 + 7);
    public int maxNiceDivisors(int primeFactors) {
        return integerBreak(primeFactors);
    }

    //参考343题
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        double res = 0;
        if (remainder == 0) {
            res = pow(3, quotient);
        } else if (remainder == 1) {
            res = pow(3, quotient - 1) * 4;
        } else {
            res = pow(3, quotient) * 2;
        }
        return (int) (res % N);
    }

    //参考50题,此处需用long，使用double会丢失精度
    public long pow(long x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x % N;
            }
            n = n >> 1;
            x =  x * x % N;
        }
        return ans;
    }
}
