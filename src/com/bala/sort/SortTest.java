package com.bala.sort;

import java.lang.reflect.Array;
import java.util.*;

public class SortTest {
    public static int[][] findContinuousSequence(int target) {
        int[][] ans = new int[target/2][0];
        int ansIndex = 0;
        int l = 1, r = 2;
        int t = l+r;
        while(l < r&&r<target){
            if(t < target){
                r++;
                t+=r;
            }else if(t == target){
                int[] a = new int[r-l+1];
                for(int i = 0;i < a.length;i++){
                    a[i] = l+i;
                }
                ans[ansIndex] = a;
                ansIndex++;
                t-=l;
            }else{
                t-=l;
                l++;
            }
        }
        return Arrays.copyOfRange(ans, 0, ansIndex);
    }

    public static void main(String[] args) {
        int[] a = {3,2,1};
        int[] r = getLeastNumbers(a, 2);
        System.out.println(Arrays.toString(r));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length-1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }
    public static void quicksort(int[] arr, int start, int end, int k){
        if(start >= end) return;
        int pivot = arr[start];
        int l = start, r = end;
        while(l<r){
            while(l < r&&arr[r]>pivot)
                r--;
            while(l < r&&arr[l] >= pivot)
                l++;
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[start] = arr[l];
        arr[l] = pivot;
        if(l<k-1){
            quicksort(arr, l+1, end, k);
        }else if(l > k){
            quicksort(arr, start, l-1, k);
        }
    }
}
