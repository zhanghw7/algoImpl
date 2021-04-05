package com.bala.heap;

import org.junit.Test;

import java.util.Comparator;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/1 9:30
 */
public class HeapTest {
    @Test
    public void test(){
        int[] arr = {99, 1,3,2,9,5, 56, -2};
        MyPriorityQueue<Integer> q = new MyPriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int value : arr) {
            q.offer(value);
        }
        while (q.size() > 0){
            System.out.println(q.poll());
        }
    }
}
