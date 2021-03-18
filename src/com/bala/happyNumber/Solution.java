package com.bala.happyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n){
        return helper(new HashSet<>(),n);
    }
    private static boolean helper(Set<Integer> set, int n){
        if (n==1) return true;
        if (set.contains(n))
            return false;
        set.add(n);
        int sum = 0;
        while (n>0){
            sum+=Math.pow(n%10,2);
            n /= 10;
        }
        return helper(set, sum);
    }
}
