package com.bala.traprainwater;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height){
        int ans = 0;
        int[] left = new int[height.length];
        int[] right= new int[height.length];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        for (int i = right.length-2; i >=0 ; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        for (int i = 0; i < height.length; i++) {
            int m = Math.min(right[i],left[i]);
            ans+= Math.max((m - height[i]), 0);
        }
        return ans;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap2(int[] height){
        int max = 0;
        int lHighest = 0, rHighest = 0;
        int l = 0, r = height.length-1;
        while (l<r){
            lHighest = Math.max(lHighest, height[l]);
            rHighest = Math.max(rHighest, height[r]);
            if (lHighest < rHighest){
                max+=lHighest-height[l];
                l++;
            }else{
                max += rHighest - height[r];
                r--;
            }
        }
        return max;
    }
}
