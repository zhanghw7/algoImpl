package com.bala.combainationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new LinkedList<>();
        helper(lists, new LinkedList<>(), 0, 0, 0, k, n);
        return lists;
    }
    private static void helper(List<List<Integer>> lists, LinkedList<Integer> list, int sum, int count, int index, int k, int n){
        if (count == k&&sum == n){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = index+1; i < 10&&count<=k; i++) {
            list.addLast(i);
            helper(lists, list, sum+i, count+1, i, k, n);
            list.removeLast();
        }
    }
}
