package com.bala;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/3/18 17:57
 */

public class EverythingTest {
    @Test
    public void test(){

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = "A".getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        byte[] encode = encoder.encode(bytes);
        System.out.println(encode.length);
        System.out.println(new String(encode));
    }

    public static int[] getOrder(int[][] tasks) {
        Queue<Integer> availableTasks = new PriorityQueue<>((o1, o2) -> {
            if (tasks[o1][1] == tasks[o2][1]){
                return o1 - o2;
            }else {
                return tasks[o1][1] - tasks[o2][1];
            }
        });

        int[] res = new int[tasks.length];
        int j = 0;
        int time = 1;
        int nextIdleTime = 1;
        int i = 0;
        while (j < res.length){
            while (i < tasks.length){
                if (tasks[i][0] == time){
                    availableTasks.offer(i);
                    i++;
                }else {
                    break;
                }
            }
            if (time == nextIdleTime && !availableTasks.isEmpty()){
                Integer t = availableTasks.poll();
                nextIdleTime = time + tasks[t][1];
                res[j] = t;
                j++;
            }
            time++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] tasks = {{7,10}, {7, 12},{7,5},{7,4},{7,2} };
        int[] order = getOrder(tasks);
        System.out.println(Arrays.toString(order));
    }
}
