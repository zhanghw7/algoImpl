package com.bala.multiplystrings;

public class Solution2 {
    public String multiply(String num1, String num2){
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        int[] mul = new int[num1.length()+num2.length()];
        for (int i = num2.length()-1; i >=0 ; i--) {
            int p = mul.length-1-(num2.length()-1-i);
            for (int j = num1.length()-1; j >=0 ; j--) {
                int temp = (num1.charAt(j) - '0')*(num2.charAt(i)-'0')+mul[p];
                mul[p] =temp %10;
                p++;
                mul[p] = temp/10+mul[p];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mul[0]==0?"":mul[0]);
        for (int i = 1; i < mul.length; i++) {
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
