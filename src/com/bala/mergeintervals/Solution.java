package com.bala.mergeintervals;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals){
        if (intervals.length==1||intervals.length==0)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
       int[][] res = new int[intervals.length][2];
       int p = 0;
       res[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>res[p][1]){
                p++;
                res[p] = intervals[i];
            }
            else {
                res[p][1] = Math.max(intervals[i][1], res[p][1]);
            }
        }

        return Arrays.copyOf(res, p+1);
    }
}
