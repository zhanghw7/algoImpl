package com.bala.heap;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/3/31 15:59
 */
public class PriorityQueue {
    private int[] heap;

    private int actualSize;

    private static int DEFAULT_SIZE = 16;

    public PriorityQueue(int[] arr) {
        int realArrLen;
        int[] newHeap;
        if (arr.length >= DEFAULT_SIZE){
            realArrLen = arr.length > Integer.MAX_VALUE / 2 ? Integer.MAX_VALUE : 2 * arr.length;
        }else {
           realArrLen = DEFAULT_SIZE;
        }
        newHeap = new int[realArrLen];
        System.arraycopy(arr, 0, newHeap, 0, arr.length);
        heap = newHeap;
        actualSize = arr.length;
        build();
    }

    public int peek(){
        return heap[0];
    }

    public int poll(){
        if (actualSize == 0){
            return Integer.MIN_VALUE;
        }
        swap(0, --actualSize);
        maxHeapify(0);
        return heap[actualSize];
    }

    public void add(int newInt){
        if (actualSize == heap.length){
            inflate();
        }
        heap[actualSize++] = newInt;
        build();
    }

    private void inflate(){
        int realArrLen;
        realArrLen = heap.length < Integer.MAX_VALUE / 2 ? 2 * heap.length : Integer.MAX_VALUE;
        int[] newHeap = new int[realArrLen];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    public void build(){
        for (int i = actualSize / 2; i >= 0 ; i--) {
            maxHeapify(i);
        }
    }

    public void maxHeapify(int p){
        if (p < actualSize){
            int l = 2 * p + 1;
            int r = 2 * p + 2;
            int m = max(l, r);
            if (m != -1 && heap[p] < heap[m]){
                swap(p, m);
                maxHeapify(m);
            }
        }
    }

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private int max(int a, int b){
        if (a < actualSize && b < actualSize){
            return heap[a] > heap[b] ? a : b;
        }else if(b < actualSize){
            return b;
        }else if (a < actualSize){
            return a;
        }else {
            return -1;
        }
    }
}
