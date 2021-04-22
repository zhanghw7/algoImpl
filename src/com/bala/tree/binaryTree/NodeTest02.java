package com.bala.tree.binaryTree;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/14 10:05
 */
public class NodeTest02 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        rbTest();
        long e1 = System.currentTimeMillis();

        long s2 = System.currentTimeMillis();
        avlTest();
        long e2 = System.currentTimeMillis();

        System.out.println("rb test 耗费时间:" + (e1 - s1));
        System.out.println("avl test 耗费时间:" + (e2 - s2));

    }

    private static void rbTest(){
        Random r = new Random(10);
        RedBlackTree rb = new RedBlackTree();
        int temp = 0;
        for (int i = 10000000; i > 1; i--) {
            temp = r.nextInt() % 10000000;
            System.out.println(temp);
            rb.insert(temp);
        }
        System.out.println(rb.inorderTraversal());
    }

    private static void avlTest(){
        Random r = new Random(10);
        AVLTree avl = new AVLTree();
        int temp = 0;
        for (int i = 10000000; i > 1; i--) {
            temp = r.nextInt() % 10000000;
            System.out.println(temp);
            avl.insert(temp);
        }
        System.out.println(avl.inorderTraversal());
    }
}
