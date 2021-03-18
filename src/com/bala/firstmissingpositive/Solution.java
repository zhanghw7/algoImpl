package com.bala.firstmissingpositive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int firstMissingPositive(int[] nums) {
       boolean[] find = new boolean[nums.length+2];
       int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0&&nums[i]<=nums.length){
                find[nums[i]] = true;
            }
        }
        while (ans<find.length-1){
            if (!find[ans]){
                break;
            }
            ans++;
        }
        return ans;
    }
}
