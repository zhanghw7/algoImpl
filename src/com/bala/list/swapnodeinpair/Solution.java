package com.bala.list.swapnodeinpair;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * Example:
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode iter = dummy;
        while (iter.next!=null&&iter.next.next!=null){
            swap(iter);
            iter = iter.next.next;
        }
        return dummy.next;
    }
    private void swap(ListNode preNode){
        ListNode dummy = preNode.next;
        preNode.next = dummy.next;
        dummy.next = dummy.next.next;
        preNode.next.next = dummy;
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 示例 :
     * 给定这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode line = dummy;
        ListNode cur = dummy.next;
        Deque<ListNode> stack = new LinkedList<>();
        while (cur!=null) {
            for (int i = 0; i < k&&cur!=null; i++) {
                stack.push(cur);
                cur = cur.next;
            }
            if(stack.size()<k)
                break;
            while (!stack.isEmpty()){
                line.next = stack.pop();
                line = line.next;
            }
            line.next = cur;
        }
        return dummy.next;
    }
    /*public ListNode reverseKGroup2(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode lastNode = dummy.next;
        while (lastNode!=null){
            int i = 0;
            while (i<k&&lastNode!=null){
                lastNode = lastNode.next;
                i++;
            }
            if (i<k)
        }
    }*/



}
