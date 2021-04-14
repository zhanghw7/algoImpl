package com.bala.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 实现AVL Tree
 * @Author Zhang Hongwei
 * @Date 2021/4/8 9:13
 */
public class AVLTree {
    private Node top;

    public void insert(int value){
        if (top == null){
            top = new Node(value, 0, null, null, null);
        }else {
            Node n = top;
            while (true){
                if (value > n.value){
                    if (n.right == null){
                        n.right = new Node(value, 0, n, null, null);
                        traceUp(n.right);
                        break;
                    }else {
                        n = n.right;
                    }
                }else if (value < n.value){
                    if (n.left == null){
                        n.left = new Node(value, 0, n, null, null);
                        traceUp(n.left);
                        break;
                    }else {
                        n = n.left;
                    }
                }else {
                    break;
                }
            }
        }
    }

    public boolean delete(int value){
        if (top == null){
            return false;
        }
        if (top.value == value && top.left == null && top.right == null){
            top = null;
            return true;
        }
        Node target = find(value);
        if (target == null){
            return false;
        }else if (target.right != null){
            if (target.right.left != null){
                Node inorderSuccessor = findInorderSuccessor(target);
                Node inorderSuccessorPre = inorderSuccessor.pre;
                Node inorderSuccessorRight = inorderSuccessor.right;
                inorderSuccessorPre.left = inorderSuccessorRight;
                if (inorderSuccessorRight != null){
                    inorderSuccessorRight.pre = inorderSuccessorPre;
                }
                target.value = inorderSuccessor.value;//这里直接替换了删除目标的value值
                traceUp(inorderSuccessorPre);
            }else {
                Node pre = target.pre;
                Node left = target.left;
                Node right = target.right;
                right.pre = pre;
                if (pre != null){
                    if (target.value > pre.value){
                        pre.right = right;
                    }else {
                        pre.left = right;
                    }
                }
                right.left = left;
                if (left != null){
                    left.pre = right;
                }
                Node traceNode = right.left != null ? right.left : right.right != null ? right.right : right;
                traceUp(traceNode);
            }

        }else if (target.left != null){
            Node pre = target.pre;
            Node left = target.left;
            left.pre = pre;
            if (pre != null){
                if (target.value > pre.value){
                    pre.right = left;
                }else {
                    pre.left = left;
                }
            }
            traceUp(left);
        }else {
            Node pre = target.pre;
            target.pre = null;
            if (target.value > pre.value){
                pre.right = null;
            }else {
                pre.left = null;
            }
            traceUp(pre);
        }
        return true;
    }

    private Node find(int value){
        Node res = null;
        Node iter = top;
        while (iter != null){
            if (iter.value == value){
                res =  iter;
                break;
            }else if (value > iter.value){
                iter = iter.right;
            }else {
                iter = iter.left;
            }
        }
        return res;
    }

    private Node findInorderSuccessor(Node node){
        Node iter = node.right;
        while (iter.left != null){
            iter = iter.left;
        }
        return iter;
    }

    //新增的节点向上回溯，更新高度并fix AVL property
    private void traceUp(Node node){
        reCal(node);
        while (node.pre != null && (balance(node.pre) >= -1 && balance(node.pre) <= 1)){
            reCal(node.pre);
            node = node.pre;
        }
        Node pre = node.pre;
        if (pre != null){
            if (balance(node) > 0 && balance(pre) > 0){
                rightRotate(pre);
            }else if (balance(node) > 0 && balance(pre) < 0){
                rightRotate(node);
                leftRotate(pre);
            }else if (balance(node) < 0 && balance(pre) < 0){
                leftRotate(pre);
            }else {
                leftRotate(node);
                rightRotate(pre);
            }
        }
    }

    private void rightRotate(Node node){
        Node pre = node.pre;
        Node left = node.left;
        Node leftRight = left == null ? null :left.right ;

        node.left = leftRight;
        if (leftRight != null){
            leftRight.pre = node;
        }
        if (left != null){
            left.right =node;
            left.pre = pre;
        }
        node.pre = left;

        if (pre != null){
            if (pre.value > node.value){
                pre.left = left;
            }else {
                pre.right = left;
            }
        }else {
            this.top = left;
        }
        reCal(node);
        reCal(left);
    }

    private void leftRotate(Node node){
        Node right = node.right;
        Node pre = node.pre;
        Node rightLeft = right == null ? null : right.left;

        node.right = rightLeft;
        if (rightLeft != null){
            rightLeft.pre = node;
        }
        if (right != null){
            right.left = node;
            right.pre = pre;
        }
        node.pre = right;

        if (pre != null){
            if (pre.left.value == node.value){
                pre.left = right;
            }else {
                pre.right = right;
            }
        }else {
            this.top = right;
        }
        reCal(node);
        reCal(right);
    }


    private void reCal(Node node){
        if (node == null){
            return;
        }
        int l = node.left == null ? -1 : node.left.height;
        int r = node.right == null ? -1 : node.right.height;
        node.height = Math.max(l, r) + 1;
    }

    private int balance(Node node){
        int l = node.left == null ? -1 : node.left.height;
        int r = node.right == null ? -1 : node.right.height;
        return l - r;
    }


    public List<Integer> inorderTraversal(){
        if (top == null){
            return new ArrayList<>();
        }
        return inorderTraversal(top);
    }
    private List<Integer> inorderTraversal(Node node){
        System.out.println(balance(node) + "," + node.value);
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

      static class Node{
        int value;
        public int height;
        Node pre;
        Node left;
        Node right;

         public Node(int value, int height, Node pre, Node left, Node right) {
            this.value = value;
            this.height = height;
            this.pre = pre;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)){
                return false;
            }
            Node node = (Node)obj;
            return node.value == this.value;
        }
    }

    public Node getTop() {
        return top;
    }
}
