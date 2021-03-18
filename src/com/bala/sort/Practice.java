package com.bala.sort;

import java.util.Arrays;

public class Practice {
    public static void quickSort(int[][] nums){
        helper(nums,0,nums.length-1);
    }
    public static void helper(int[][] nums, int start, int end){
       if (start>=end) return;
       int l = start;
       int r = end;
       while (l<r){
           while (nums[r][0]>=nums[start][0]&&r!=l) r--;
           while (nums[l][0]<=nums[start][0]&&r!=l) l++;
           swap(nums,l,r);//交换位置
       }
       swap(nums,start,l);//交换位置
       helper(nums,start,l-1);
       helper(nums,l+1,end);
    }
    public static void swap(int[][] nums, int index1, int index2){
        int[] temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] =temp;
    }

    public static void main(String[] args) {
        /*int[] arr= {1,3,5,9,2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }
}
