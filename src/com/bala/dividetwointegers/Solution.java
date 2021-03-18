package com.bala.dividetwointegers;

public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MIN_VALUE;
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while (temp_divisor > (Integer.MIN_VALUE >> 1)){
               temp_divisor = temp_divisor << 1;
               if (temp_divisor < dividend){
                  temp_divisor = temp_divisor >> 1;
                   break;
               }else
                   temp_result = temp_result << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!sign) result = -result;
        return result;
    }
}
