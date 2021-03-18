package com.bala.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> curList = new LinkedList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int num : nums) {
            queue.offer(num);
        }
        helper(queue, curList, lists);
        return lists;
    }
    public static void helper(Queue<Integer> queue, List<Integer> curList,List<List<Integer>> lists){
        if (queue.isEmpty()) {
            lists.add(new LinkedList<>(curList));
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
//            Integer first = queue.poll();
//            List<Integer> newList = new LinkedList<>(curList);
//            newList.add(first);
//            Queue<Integer> newQue = new LinkedList<>(queue);
//            helper(newQue,newList,lists);
//            queue.offer(first);
            Integer first = queue.poll();
            curList.add(first);
            helper(queue,curList,lists);
            curList.remove(curList.size()-1);//执行到这里时，上一步肯定已经执行完毕，所以可以放心remove
            queue.offer(first);

        }
    }

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    public static List<List<Integer>> permute2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> curList = new LinkedList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int num : nums) {
            queue.offer(num);
        }
        helper2(queue, curList, lists);
        return lists;
    }
    public static void helper2(Queue<Integer> queue, List<Integer> curList,List<List<Integer>> lists){
        if (queue.isEmpty()) {
            lists.add(new LinkedList<>(curList));
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            if (i!=0&&((LinkedList)queue).getFirst()==((LinkedList)queue).getLast()) {
                queue.offer(queue.poll());
                continue;
            }
            Integer first = queue.poll();
            curList.add(first);
            helper2(queue,curList,lists);
            curList.remove(curList.size()-1);
            queue.offer(first);

        }
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(permute2(arr));
    }
}
