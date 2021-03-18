package com.bala.twoSumAndthreeSum;

import java.util.*;

public class Solution {
/*
两数之和
 */
    public int[] addTwo(int[] arr,int target ){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i <arr.length ; i++) {
           if( hashMap.containsKey(target-arr[i])){
               answer[0]=hashMap.get(target-arr[i]);
               answer[1]=i;
            }
           else
               hashMap.put(arr[i],i);
        }
        if(answer!=null)
            return answer;
        else
            System.out.println("no match answer");
        return null;
    }
    /*
    三数之和
     */
    public static List<List<Integer>> threeSum(int[] nums,int target) {
        if (nums==null||nums.length<3) return null;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int i =0;
        while(i<nums.length-2){
            if (i!=0&&nums[i]==nums[i-1]) { //去重
                i++;
                continue;
            }
            int j = i+1; //left
            int k = nums.length-1; //right
            while(j<k){
                if (j >= i+2&&nums[j]==nums[j-1]){ //去重
                    j++;
                    continue;
                }
                if (k!=nums.length-1&&nums[k]==nums[k+1]){ //去重
                    k--;
                    continue;
                }
                int sum = nums[k]+nums[j]+nums[i];
                if (sum==target) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    j++;
                    k--;
                }else if (sum>target) k--;
                else j++;
            }
            i++;
        }
        return lists;
    }
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    public static int threeSumClosest(int[] nums,int target){
        if (nums==null||nums.length<=2) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] +nums[2];
        for (int i = 0; i < nums.length-2; i++) { //不需要去重
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[left] + nums[right] +nums[i];
                closest = Math.abs(sum-target) < Math.abs(closest-target) ? sum:closest;
                if (sum ==target)
                    return target;
                else if (sum>target) right--;
                else left++;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
