package com.bala.tree.binaryTree;

import java.util.*;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(inorderTraversal(root.left));
            }
            list.add(root.val);
            if (root.right != null) {
                list.addAll(inorderTraversal(root.right));
            }
        }
        return list;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null != root) {
            list.add(root.val);
            if (null != root.left) {
                list.addAll(preorderTraversal(root.left));
            }
            if (null != root.right) {
                list.addAll(preorderTraversal(root.right));
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }

    /**
     * 递归前序遍历比较
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) {
            if (p.val != q.val) return false;
            else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        } else return false;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else
            return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }
    public TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if(preL > preR || inL > inR){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preL]);
        if(preL == preR){
            return treeNode;
        }
        int rootNodeIndexOfIn = find(inorder, preorder[preL]);
        if (rootNodeIndexOfIn == -1){
            throw new RuntimeException("错误");
        }
        treeNode.left = buildTree(preorder,preL + 1, rootNodeIndexOfIn + preL - inL, inorder, inL, rootNodeIndexOfIn - 1);
        treeNode.right = buildTree(preorder, rootNodeIndexOfIn + preL - inL + 1, preR, inorder, rootNodeIndexOfIn + 1, inR);
        return treeNode;
    }
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        System.out.println(treeNode);

    }
    public int find(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
