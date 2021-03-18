package com.bala.array;

import java.util.*;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {//按每个一维数组首位排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] newArr = new int[intervals.length][2];
        newArr[0] = intervals[0];
        int curIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > newArr[curIndex][1]) {
                curIndex++;
                newArr[curIndex] = intervals[i];
            } else {
                newArr[curIndex][1] = Math.max(newArr[curIndex][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(newArr, curIndex + 1);//去掉后面为0的一维数组
    }

    /*
    给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//这个是自己写的，不够简单
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                boolean find = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        swap(nums, i, j);
                        find = true;
                        break;
                    }
                }
                if (!find) break;
            }
            i++;
        }
        return i;
    }

    //leetcode的答案，双指针
    public int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //双指针，找到就用最后一位替换
    public int removeElement3(int[] nums, int val) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r - 1];
                r--;
            } else
                l++;
        }
        return r;
    }


    /*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    示例 1:

    给定数组 nums = [1,1,2],

    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    你不需要考虑数组中超出新长度后面的元素。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//双指针，思路和上面removeElement2一样
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int s = 1;//slow
        for (int i = 1; i < nums.length; i++) { //i:fast
            if (nums[i] != nums[i - 1]) {
                nums[s] = nums[i];
                s++;
            }
        }
        return s;
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]))
                return new int[]{hm.get(target - nums[i]), i};
            else hm.put(nums[i], i);
        }
        return null;
    }

    /**
     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     你可以假设数组中无重复元素。
     示例 1:
     输入: [1,3,5,6], 5
     输出: 2
     示例 2:
     输入: [1,3,5,6], 2
     输出: 1
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/search-insert-position
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 从头到尾遍历查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= target) break;
            i++;
        }
        return i;

    }

    /**
     * 二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0)
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] > height[right]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            } else if (height[left] == height[right]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
                left++;
            } else {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }
        }
        return max;

    }

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchRotatedSortedArray(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid;
                else left = mid;
            } else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right])
                    left = mid;
                else right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int start = -1;
        int end = -1;
        //找起点index
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {//找起点index
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) right = mid;
            if (target > nums[mid]) left = mid;
        }
        if (nums[left] == target) start = left;
        else if (nums[right] == target) start = right;
        if (start == -1) return new int[]{-1, -1};
        //找终点index
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) right = mid;
            if (target >= nums[mid]) left = mid;
        }
        if (nums[right] == target) end = right;
        else if (nums[left] == target) end = left;

        return new int[]{start, end};
    }

    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间。
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,6,4,2->1,4,2,2,6
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int target = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[target]) {
                    swap(nums, j, target);
                    target = j;
                    break;
                }
                }
            Arrays.sort(nums,target,nums.length);
            if (target!=i) return;
        }
        Arrays.sort(nums);
    }
    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //这个方法思路较清晰
    public void nextPermutation2(int[] nums){
        int replace = nums.length-2;
        while (replace>=0){
            if (nums[replace]<nums[replace+1]) break;
            replace--;
        }
        if (replace<0){
            Arrays.sort(nums);
            return;
        }
        int larger = replace+1;
        while (larger<nums.length&&nums[larger]>nums[replace]){
            larger++;
        }
        swap(nums,replace,larger-1);
        Arrays.sort(nums,replace+1,nums.length);
    }

    public static void reverse ( int[] nums){
        if (nums.length == 0) return;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        Set<Integer> set = new HashSet<>();
        for (int b : B) {
            set.add(b);
        }

        int[] result = new int[2];
        for (int a : A) {
            int b = a + (sumB - sumA) / 2;
            if (set.contains(b)) {
                result[0] = a;
                result[1] = b;
                break;
            }
        }
        return result;
    }

    public static int maxTurbulenceSize(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int i = 1, count = 1, result = 1;
        while(i < arr.length){
            if(count == 1){
                if(arr[i] != arr[i - 1]){
                    count++;
                }
                i++;
                continue;
            }
            int mul = (arr[i] - arr[i - 1]) * (arr[i - 1] - arr[i - 2]);
            if (mul < 0){
                count++;
                i++;
            }else {
                result = Math.max(result, count);
                if (count == 10){
                    System.out.println(arr[i]);
                }
                count = 1;
            }
        }
        return Math.max(result, count);
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,4,2,5,0,1,2,3};
        int i = maxTurbulenceSize2(arr);
        System.out.println(i);
    }

    public static int maxTurbulenceSize2(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int up = 1, down = 1, result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]){
                up = down + 1;
                down = 1;
            }else if (arr[i] < arr[i - 1]){
                down = up + 1;
                up = 1;
            }else {
                result = Math.max(Math.max(up, down), result);
                up = 1;
                down = 1;
            }
        }
        return Math.max(Math.max(up, down), result);
    }
}
