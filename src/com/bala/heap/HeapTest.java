package com.bala.heap;

import org.junit.Test;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/1 9:30
 */
public class HeapTest {
    @Test
    public void test(){
        int[] arr = {23, 1,3,2,9,5, 56};
        MyPriorityQueue<Integer> q = new MyPriorityQueue<>();
        for (int value : arr) {
            q.offer(value);
        }
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
