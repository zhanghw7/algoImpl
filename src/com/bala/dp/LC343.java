package com.bala.dp;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/21 11:08
 */
public class LC343 {
    /**
     * 证明：
     * 1：拆分值不能大于或等于4
     * 2. n > 3时，拆分值不能为1
     * 3. 2的个数小于3
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if(n <= 3){
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        int res = 0;
        if (remainder == 0){
            res = (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            res = (int) (Math.pow(3, quotient - 1) * 4);
        }else {
            res = (int) (Math.pow(3, quotient) * 2);
        }
        return res;
    }
}
