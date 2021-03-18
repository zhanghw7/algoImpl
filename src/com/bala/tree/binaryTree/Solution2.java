package com.bala.tree.binaryTree;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2020/9/13 21:56
 */
public class Solution2 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            int[] arr = convertToArray(head);
            return sortedListToBST(arr, 0, arr.length - 1);
        }

        public int[] convertToArray(ListNode head){
            int[] arr = new int[getLength(head)];
            int i = 0;
            while(head != null){
                arr[i] = head.val;
                head = head.next;
                i++;
            }
            return arr;
        }

        public int getLength(ListNode head){
            int length = 0;
            while(head != null){
                length++;
                head = head.next;
            }
            return length;
        }

        public TreeNode sortedListToBST(int[] arr, int l, int r) {
            if(arr.length == 0 || l > r){
                return null;
            }
            if(l == r){
                return new TreeNode(arr[l]);
            }

            int m = l + (r - l)/2;
            return new TreeNode(arr[m], sortedListToBST(arr, l, m-1), sortedListToBST(arr, m+1, r));

        }
    }

    public static void main(String[] args) {

    }
}
