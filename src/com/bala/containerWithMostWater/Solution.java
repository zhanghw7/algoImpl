package com.bala.containerWithMostWater;

public class Solution {
/*
Given n non-negative integers a1, a2, ..., an , where each represents
 a point at coordinate (i, ai). n vertical lines are drawn such that the two
 endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    public static int maxArea(int[] container){
        int left = 0;
        int right = container.length-1;
        int maxArea = 0;
        while(left<right){
            maxArea = Math.max(maxArea,(right-left)*Math.min(container[left],container[right]));
            if (container[right]>container[left]) left++;
            else if (container[right]<container[left]) right--;
            else {
                right--;
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] c = {2,1,3,4};
        System.out.println(maxArea(c));
    }
}
