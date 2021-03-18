package com.bala.combainationSum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        helper(lists, new LinkedList<>(), 0, target, candidates, 0);
        return lists;
    }
    private static void helper(List<List<Integer>> lists, Deque<Integer> stack, int sum, int target,int[] candidates, int index){
        if (sum==target){
            lists.add(new LinkedList<>(stack));
            return;
        }
        if (sum>target) return;
        for (int i = index; i < candidates.length; i++) {
            stack.offer(candidates[i]);
            helper(lists, stack, sum+candidates[i], target, candidates, i );
            stack.pop();
        }
    }


}
