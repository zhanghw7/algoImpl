package com.bala.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 实现红黑树
 * @Author Zhang Hongwei
 * @Date 2021/4/13 9:12
 */
public class RedBlackTree {
    private Node root;

     static class Node{
        int value;
        boolean isRed;
        Node pre;
        Node left;
        Node right;

        public Node(int value, boolean isRed, Node pre, Node left, Node right) {
            this.value = value;
            this.isRed = isRed;
            this.pre = pre;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int newVal, boolean isRed) {
            this.value = newVal;
            this.isRed = isRed;
        }

        public Node(int newVal, boolean isRed, Node pre) {
            this(newVal,isRed);
            this.pre = pre;
        }
    }

    private void rightRotate(Node node){
        Node pre = node.pre;
        Node left = node.left;
        if (left == null){
            throw new RuntimeException("should not right rotate");
        }
        Node leftRight = left.right;

        node.left = leftRight;
        if (leftRight != null){
            leftRight.pre = node;
        }

        left.right = node;
        node.pre = left;

        left.pre = pre;
        if (pre == null){
            root = left;
        }else {
            if (node.value > pre.value){
                pre.right = left;
            }else {
                pre.left = left;
            }
        }
    }

    private void leftRotate(Node node){
        Node pre = node.pre;
        Node right = node.right;
        if (right == null){
            throw new RuntimeException("should not left rotate");
        }
        Node rightLeft = right.left;

        node.right = rightLeft;
        if (rightLeft != null){
            rightLeft.pre = node;
        }

        node.pre = right;
        right.left = node;

        right.pre = pre;
        if (pre == null){
            root = right;
        }else {
            if (node.value > pre.value){
                pre.right = right;
            }else {
                pre.left = right;
            }
        }
    }

    public void insert(int newVal){
        Node iter = BSTInsert(newVal);
        while (iter != null && iter.isRed){
            Node p = iter.pre;
            if (p == null){
                throw new RuntimeException("p should not be null");
            }
            if (isBlack(p)){
                return;
            }
            Node pp = p.pre;
            if (pp == null /*|| isRed(pp)*/){
                throw new RuntimeException("pp should not be null or red");
            }
            if (isLeftChild(pp, p)){
                if (isRed(pp.right)){
                    p.isRed = false;
                    pp.right.isRed = false;
                    if (pp != root){
                        pp.isRed = true;
                    }
                    iter = pp;
                }else {
                    if (isRightChild(p, iter)){
                        leftRotate(p);
                    }
                    rightRotate(pp);
                    p.isRed = false;
                    pp.isRed = true;
                    iter = p;
                }
            }else {
                if (isRed(pp.left)){
                    p.isRed = false;
                    pp.left.isRed = false;
                    if (pp != root){
                        pp.isRed = true;
                    }
                    iter = pp;
                }else {
                    if (isLeftChild(p, iter)){
                        rightRotate(p);
                    }
                    leftRotate(pp);
                    p.isRed = false;
                    pp.isRed = true;
                    iter = p;
                }
            }
        }




    }

    private boolean isRed(Node node){
        return node != null && node.isRed;
    }

    private boolean isBlack(Node node){
        return ! isRed(node);
    }

    //is c the  left child of p or not
    private boolean isLeftChild(Node p, Node c){
        return c.value < p.value;
    }

    private boolean isRightChild(Node p, Node c){
        return c.value > p.value;
    }

    private Node BSTInsert(int newVal){
        Node newNode = null;
        if (root == null){
            root = new Node(newVal);
            newNode = root;
        }else {
            Node iter = root;
            while (true){
                if (newVal > iter.value){
                    if (iter.right == null){
                        iter.right = new Node(newVal, true, iter);
                        newNode = iter.right;
                        break;
                    }else {
                        iter = iter.right;
                    }
                }else if (newVal < iter.value){
                    if (iter.left == null){
                        iter.left = new Node(newVal, true, iter);
                        newNode = iter.left;
                        break;
                    }else {
                        iter = iter.left;
                    }
                }else {
                    break;
                }
            }
        }

        return newNode;
    }

    public List<Integer> inorderTraversal(){
        if (root == null){
            return new ArrayList<>();
        }
        return inorderTraversal(root);
    }
    private List<Integer> inorderTraversal(Node node){
        List<Integer> result = new ArrayList<>();
        if (node.left != null){
            result.addAll(inorderTraversal(node.left));
        }
        result.add(node.value);
        if (node.right != null){
            result.addAll(inorderTraversal(node.right));
        }
        return result;
    }
}
