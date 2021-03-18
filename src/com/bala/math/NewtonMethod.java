package com.bala.math;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/2/7 10:54
 */
public class NewtonMethod {
    public static double sqrt(int n, int c) {
        if (n <= 0) {
            return Double.NaN;
        }
        double x = c;
        double y = (x + c / x) / 2;
        while (n > 0) {
            x = y;
            y = (x + c / x) / 2;
            n--;
        }
        return x;
    }

    public static void main(String[] args) {
        double sqrt = sqrt(2, 2);
        System.out.println(sqrt);
    }
}
