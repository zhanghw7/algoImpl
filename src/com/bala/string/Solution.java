package com.bala.string;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.charAt(i)==needle.charAt(0)) {
                boolean find = true;
                for (int j = i, k = 0; j < haystack.length()&&k<needle.length(); j++,k++) {
                    if (haystack.charAt(j)!=needle.charAt(k)) {
                        find = false;
                        break;
                    }
                }
                if (find) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1>>6);
    }
}
