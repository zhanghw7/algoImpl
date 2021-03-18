package com.bala.sort;

import java.util.Arrays;

public class Sort {
    /*
        merge sort
     */
    public static int[] mergeSort(int[] arr){
        if (arr == null || arr.length == 0){
            return new int[]{};
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int[] mergeSort(int[] arr, int l, int r){
        if (l == r){
            return new int[]{arr[l]};
        }
        int m = (l + r) / 2;
        int[] leftInts = mergeSort(arr, l, m);
        int[] rightInts = mergeSort(arr, m + 1, r);
        return merge(leftInts, rightInts);
    }

    public static int[] merge(int[] a, int[] b){
        int[] ret = new int[a.length + b.length];
        int l = 0, r = 0, i = 0;
        while (l < a.length && r < b.length){
            if (a[l] > b[r]){
                ret[i++] = b[r++];
            }else if (a[l] < b[r]){
                ret[i++] = a[l++];
            }else {
                ret[i++] = a[l++];
                ret[i++] = b[r++];
            }
        }
        if (l < a.length){
            System.arraycopy(a, l, ret, i, a.length - l);
        }
        if (r < b.length){
            System.arraycopy(b, r, ret, i, b.length - r);
        }
        return ret;
    }

    /*
    选择排序法
     */
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
    }

    /*
    快速排序
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (right <= left || arr.length == 0)
            return;
        int pivot = arr[left];
        int l = left, r = right, temp;
        while (l < r) {
            while (arr[r] >= pivot && l < r) {//需要右边先移动
                r--;
            }
            while (arr[l] <= pivot && l < r) {
                l++;
            }
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

        }

        arr[left] = arr[r];
        arr[r] = pivot;
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);


    }

    /*
    冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 获取数组中大于target的数中最小的一个
     *
     * @param arr 已排序的数组
     * @return
     */
    public static int getSmallestBigger(int[] arr, int target, int l, int r) {
        if (r < l)
            return -1;
        int middle = 0;
        while (r - l > 1) {
            middle = l + (r - l) / 2;
            if (arr[middle] == target)
                return middle;
            else if (arr[middle] > target) {
                r = middle;
            } else {
                l = middle;
            }
        }
        return arr[l] >= target ? l : (arr[r] >= target ? r : -1);
    }

    /**
     * 最长上升子序列
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int suitableIndex = getSmallestBigger(arr, nums[i], 0, lastIndex);
            if (suitableIndex == -1) {
                if (lastIndex == -1 || nums[i] > arr[lastIndex]) {
                    lastIndex++;
                    arr[lastIndex] = nums[i];
                }
            }else {
                arr[suitableIndex] = nums[i];
            }
        }
        return lastIndex + 1;
    }

    /**
     * 判断子序列
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int indexOfT = 0, indexOfS = 0;
        while (indexOfS < s.length() && indexOfT < t.length()){
            char cur = s.charAt(indexOfS);
            boolean flag = false;
            while (indexOfT < t.length()){
                if (cur == t.charAt(indexOfT++)){
                    flag = true;
                    break;
                }
            }
            if (flag) {
                indexOfS++;
            }
        }
        return indexOfS == s.length() && indexOfT <= t.length();
    }

    public static void main(String[] args) {
        int[] arr = {};
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
