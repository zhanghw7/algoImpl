package com.bala.multiplystrings;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(multiply(String.valueOf(Long.MAX_VALUE),String.valueOf(Long.MAX_VALUE)));
        BigInteger a = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger b = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(a.multiply(b));
        ArrayList<Object> objects = new ArrayList<>();

    }

    public static String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i < 0 ? 0 : (s1.charAt(i) - '0');
            int b = j < 0 ? 0 : (s2.charAt(j) - '0');
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1)
            sb.append(carry);
        sb.reverse();
        return sb.toString();
    }

    public static String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0"))
            return "0";
        String ans = "0";
        for (int i = num2.length()-1; i >=0 ; i--) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int a = num2.charAt(i) - '0';
            for (int j = num1.length()-1; j >=0; j--) {
                int mul = (num1.charAt(j) - '0') * a + carry;
                sb.append(mul % 10);
                carry = mul / 10;
               // System.out.println(sb.toString());
            }
            sb.append(carry==0?"":carry);
            sb.reverse();
            for (int k = num2.length()-1; k > i; k--) {
                sb.append("0");
            }
            ans = add(ans,sb.toString());
        }
        return ans;
    }
}
