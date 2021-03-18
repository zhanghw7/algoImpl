package com.bala.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/3/15 17:17
 */
public class MaxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double max = 0;
        List<List<Integer>> slices = new ArrayList<>();
        slice(slices, null, extraStudents, classes.length);
        for(List<Integer> s: slices){
            double averageSum = 0;
            for(int i = 0; i < s.size(); i++){
                averageSum+=(classes[i][0] + s.get(i)) / (double)(classes[i][1] + s.get(i));
            }
            max = Math.max(averageSum / classes.length, max);
        }
        return max;
    }

    public void slice(List<List<Integer>> slices, List<Integer> s, int number, int n){
        if(n == 0){
            slices.add(new ArrayList<>(s));
            return;
        }
        if(s == null){
            s = new ArrayList<>();
        }
        for(int i = 0; i <= number; i++){
            s.add(i);
            slice(slices, s, number - i, n - 1);
            s.remove(s.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] classes = {{2,2},{3,5},{1,2}};
        int extraStudents = 2;
        MaxAverageRatio ob = new MaxAverageRatio();
        double v = ob.maxAverageRatio(classes, extraStudents);
        System.out.println(v);
    }
}
