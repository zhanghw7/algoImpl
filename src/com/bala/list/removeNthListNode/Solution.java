package com.bala.list.removeNthListNode;
/*

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */

class Solution {
/*
两次遍历
 */
    public static ListNode removeNthNode(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        int length = 0;
        ListNode iter = dummy.next;
        while(iter!=null){
            length++;
            iter=iter.next;
        }
        length-=n;
        iter = dummy.next;
        while (length!=0){
            iter=iter.next;
            length--;
        }
        iter.next=iter.next.next;
        return dummy.next;
    }
    /*
    双指针
     */

    public static ListNode removeNthNode2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    /*
        测试
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy.next;
        for (int i = 0; i < 5; i++) {
            head.next = new ListNode((int)(Math.random()*100));
            head = head.next;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(first.val);
            first = first.next;
        }
        removeNthNode2(dummy.next,3);
        first = dummy.next;
        for (int i = 0; i < 5; i++) {
            System.out.println(first.val);
            first = first.next;
        }
    }
}
