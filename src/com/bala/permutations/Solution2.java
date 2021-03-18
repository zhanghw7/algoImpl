package com.bala.permutations;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    /**
     * 使用了队列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            q.offer(num);
        }
        helper(lists, new LinkedList<>(), q);
        return lists;
    }
    public static void helper(List<List<Integer>> lists, Deque<Integer> stack, Queue<Integer> q){
        if(q.isEmpty()){
            lists.add(new LinkedList<>(stack));
        }
        for(int i = 0;i < q.size();i++){
            Integer temp = q.poll();
            stack.push(temp);
            helper(lists, stack, q);
            stack.pop();
            q.offer(temp);
        }
    }

    /**
     * 使用数组标记是否已被使用过
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        helper2(lists, new LinkedList<>(), visited, nums);
        return lists;
    }
    public static void helper2(List<List<Integer>> lists, Deque<Integer> stack, boolean[] visited, int[] nums){
        if(stack.size()==nums.length){
            lists.add(new LinkedList<>(stack));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]){
                    stack.push(nums[i]);
                    visited[i] = true;
                    helper2(lists, stack, visited, nums);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }
}
