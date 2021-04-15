package com.bala.tree.binaryTree;

import java.util.Random;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/4/14 10:05
 */
public class NodeTest02 {
    public static void main(String[] args) {
        Random r = new Random(10);
        RedBlackTree rb = new RedBlackTree();
        int temp = 0;
        for (int i = 50; i > 1; i--) {
            temp = r.nextInt() % 50;
            System.out.println(temp);
            rb.insert(temp);
        }
        System.out.println(rb.inorderTraversal());
    }
}
