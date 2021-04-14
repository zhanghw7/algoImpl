package com.bala.bigNumber;

import java.math.BigInteger;

/**
 * @Description 实现karatsuba算法
 * @Author Zhang Hongwei
 * @Date 2021/4/6 15:54
 */
public class KaratsubaImpl {

    /*public static String multiply(String x, String y){
        if (x.length() == 1 && y.length() == 1){
            return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
        }
        int lx = x.length();
        int ly = y.length();
        int n = Math.max(lx, ly);
        int mx = lx - n / 2;
        int my = ly - n / 2;
        String x1 = x.substring(0, mx);
        String x2 = x.substring(mx);
        String y1 = y.substring(0, my);
        String y2 = y.substring(my);
        String z2 = multiply(x1, y1);
        String z0 = multiply(x2, y2);
        String z1 = multiply((x1 + x2), (y1 + y2)) - z0 - z2;
        return add0(n, z2) + add0(n / 2, z1) + z0;
    }*/

    private static String add0(int n, String target){
        StringBuilder targetBuilder = new StringBuilder(target);
        for (int i = 0; i < n; i++) {
            targetBuilder.append("0");
        }
        return targetBuilder.toString();
    }


    private  static String add(String s1, String s2){
        int l1 = s1.length() - 1;
        int l2 = s2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (l1 >= 0|| l2 >= 0){
            if (l1 >= 0 && l2 >= 0){
                int sum = s1.charAt(l1) - '0' + s2.charAt(l2) - '0' + carry;
                result.append(sum % 10);
                carry = sum / 10;
            }else if (l1 >= 0){
                int sum = s1.charAt(l1) - '0' + carry;
                result.append(sum % 10);
                carry = sum / 10;
            }else {
                int sum = s2.charAt(l2) - '0' + carry;
                result.append(sum % 10);
                carry = sum / 10;
            }
            l1--;
            l2--;
        }
        if (carry == 1){
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(10456456456L);
    }
}
