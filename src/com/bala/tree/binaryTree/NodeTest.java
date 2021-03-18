package com.bala.tree.binaryTree;

public class NodeTest {
    public static void main(String[] args) {
        Node b = new Node();
        for (int i = 0; i <20 ; i++) {
            b.add((int)(Math.random()*1000));
        }
        System.out.println(b.getSortedNode());
    }

}
