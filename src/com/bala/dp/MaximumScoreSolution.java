package com.bala.dp;

//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。
//
// 请你返回 好 子数组的最大可能 分数 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
//
//
// 示例 2：
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 2 * 104
// 0 <= k < nums.length
//
// Related Topics 贪心算法
// 👍 26 👎 0

/**
 * @Description LeetCode 1793
 * @Author Zhang Hongwei
 * @Date 2021/3/23 15:02
 */
public class MaximumScoreSolution {
    /**
     * 动态规划，理论可行，但超出内存限制，复杂度O(n2)
     * @param nums
     * @param k
     * @return
     */
    public int maximumScore(int[] nums, int k) {
        int len = nums.length;
        int[][] mins = new int[len][len];
        mins[k][k] = nums[k];
        int result = nums[k];
        for (int j = k; j < len; j++) {
            if (j > k){
                mins[k][j] = Math.min(mins[k][j - 1], mins[k][j]);
                result = Math.max(result, mins[k][j] * (j - k+ 1));
                System.out.println(result);
            }
            for (int i = k - 1; i >= 0 ; i--) {
                mins[i][j] = Math.min(mins[i + 1][j], nums[i]);
                result = Math.max(mins[i][j] * (j - i + 1), result);
            }
        }
        return result;
    }

    /**
     * 双指针 贪心算法
     * 思路：min(nums[i], ...,nums[j]) <= nums[k]
     * @param nums
     * @param k
     * @return
     */
    public int maximumScore2(int[] nums, int k){
        int res = 0;
        int l = k, r = k;
        int len = nums.length;
        while(l >= 0 || r < len){
            while(l >= 0 && nums[l] >= nums[k]) l--;
            while(r < len && nums[r] >= nums[k]) r++;
            res = Math.max(res, nums[k] * (r - l - 1));
            if(l >= 0){
                nums[k] = r >= len ? nums[l] : Math.max(nums[l], nums[r]);
            }else if (r < len){
                nums[k] = nums[r];
            }
        }
        return res;
    }
}
