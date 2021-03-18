package com.bala.list.mergedTwoList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
/*
串珠子的感觉
 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1!=null&&l2!=null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur=cur.next;
            }
        }
        cur.next = (l1==null)?l2:l1;
        return head.next;
    }

    /**
     * 合并K个list,从头到尾一个一个合并，效率有点低
     * @param lists
     * @return
     */

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = mergeTwoLists(lists[i],listNode);
        }
        return listNode;
    }

    /**
     * 利用PriorityQueue
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode list : lists){
            if(list!=null)
                queue.offer(list);
        }
        while (!queue.isEmpty()){
            ListNode temp = queue.poll();
            iter.next = temp;
            iter = iter.next;
            if (temp.next!=null)
                queue.offer(temp.next);
        }
        return dummy.next;
    }

/*
测试
 */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode dummy = l1;
        for (int i = 1; i < 5; i++) {
            ListNode l = new ListNode(i*2);

            dummy.next = l;
            dummy =dummy.next;
            System.out.println(l.val);
        }
        System.out.println("------");
        ListNode l2 = new ListNode(0);
        ListNode d1 = l2;
        for (int i = 1; i < 5; i++) {
            ListNode l = new ListNode(i*3);
            d1.next = l;
            d1 =d1.next;
            System.out.println(l.val);
        }
        System.out.println("-----");
        ListNode l3 = mergeTwoLists(l1,l2);
        while (l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}


