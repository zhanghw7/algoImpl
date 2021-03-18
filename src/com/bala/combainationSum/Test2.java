package com.bala.combainationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new LinkedList<>();
        helper(lists, new LinkedList<Integer>(), 0, target, candidates, -1);
        return lists;
    }
    private static void helper(List<List<Integer>> lists, List<Integer> list, int sum, int target,int[] candidates, int index){
        if (sum==target){
            lists.add(new LinkedList<>(list));
            return;
        }
        if (sum>target) return;
        for (int i = index+1; i < candidates.length; i++) {
            if (i!=index+1&&candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(lists, list, sum+candidates[i], target, candidates, i );
            list.remove(list.size()-1);
        }
    }



}
