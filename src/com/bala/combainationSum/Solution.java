package com.bala.combainationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    回溯算法
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists  = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(lists, list, 0, 0, target, candidates);
        return lists;
    }
    public static void helper(List<List<Integer>> lists, List<Integer> list, int cur, int sum, int target,int[] candidates){
        if (sum==target){
            lists.add(list);
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i]>target-sum) return;
            List<Integer> newList = new LinkedList<>(list);
            newList.add(candidates[i]);
            helper(lists, newList, i, sum+candidates[i], target,candidates);
        }
    }

    /*
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists  = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper2(lists, list, 0, 0, target, candidates);
        return lists;
    }
    public static void helper2(List<List<Integer>> lists, List<Integer> list, int cur, int sum, int target,int[] candidates){
        if (sum==target){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i]>target-sum) return;
            if (i!=cur&&candidates[i]==candidates[i-1]) continue;//去重条件
           /* List<Integer> newList = new LinkedList<>(list);
            newList.add(candidates[i]);
            helper2(lists, newList, i+1, sum+candidates[i], target,candidates);*/
           list.add(candidates[i]);
            helper2(lists, list, i+1, sum+candidates[i], target,candidates);
            list.remove(list.size()-1);
        }
    }


/*
网上的解法，思路一样，用的减法
 */
    public static List<List<Integer>> combinationSum3(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum3Helper(candidates, target, 0, curList,results);
        return results;

    }
    private static void combinationSum3Helper(int[] candidates, int target, int index, List<Integer> curList, List<List<Integer>> results){
        if (target==0)
            results.add(new ArrayList<Integer>(curList));
        else if (target>0){
            for (int i = index; i < candidates.length; i++) {
               if (i!=index&&candidates[i]==candidates[i-1]) continue;
                curList.add(candidates[i]);
                combinationSum3Helper(candidates, target-candidates[i], i+1,curList, results);
                curList.remove(curList.size()-1);
             }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        System.out.println(combinationSum2(arr, 5));

    }



}
