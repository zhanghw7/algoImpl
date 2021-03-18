package com.bala.subset;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> subsets(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {//将数组放入队列中
            queue.offer(num);
        }
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());//加入空子集
        backtrace(lists, new LinkedList<>(), queue);
        return lists;
    }
    private static void backtrace(List<List<Integer>> lists, List<Integer> curList, Queue<Integer> queue){
        if (queue.isEmpty()) return;
        while (!queue.isEmpty()){
           curList.add(queue.poll());
           lists.add(new LinkedList<>(curList));
           Queue<Integer> newQue = new LinkedList<>(queue);//
           backtrace(lists,curList, newQue);
           curList.remove(curList.size()-1);
        }
    }


    /*
    不用队列, 与上面的方法比起来感觉不用队列更简单
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());
        backtrace2(lists, new LinkedList<>(), nums, 0);
        return lists;
    }
    private static void backtrace2(List<List<Integer>> lists, List<Integer> curList, int[] nums, int firIndex){
        if (firIndex==nums.length) return;
        for (int i = firIndex; i < nums.length; i++) {
            curList.add(nums[i]);
            lists.add(new LinkedList<>(curList));
            backtrace2(lists, curList, nums, i+1);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(subsets2(nums));
    }
}
