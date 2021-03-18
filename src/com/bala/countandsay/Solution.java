package com.bala.countandsay;

public class Solution {
    public String countAndSay(int n) {
        if (n==1) return String.valueOf(1);
        String lastOne = countAndSay(n-1);
        int count = 1;
        char say = lastOne.charAt(0);
        StringBuilder thisOne = new StringBuilder();
        for (int i = 1; i < lastOne.length(); i++) {
            if (lastOne.charAt(i-1)==lastOne.charAt(i))
                count++;
            else {
                thisOne.append(count);
                thisOne.append(say);
                count=1;
                say = lastOne.charAt(i);
            }
        }
        thisOne.append(count);
        thisOne.append(say);
        return thisOne.toString();
    }
}
