package com.bala.heap;

import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/1 9:30
 */
public class HeapTest {
    @Test
    public void test(){
        String[] arr = {"99646545", "1","3","2","9","5", "56", "-2", "46", "89", "12"};
        List<String> list = Arrays.asList(arr);
        MyPriorityQueue<String> q = new MyPriorityQueue<>(list, (o1, o2) -> o1.length() - o2.length());
        /*for (int value : arr) {
            q.offer(value);
        }*/
        q.offer("120");
        q.offer("120");
        while (q.size() > 0){
            System.out.println(q.poll());
        }
    }
}
