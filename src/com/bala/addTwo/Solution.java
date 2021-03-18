package com.bala.addTwo;

public class Solution {

    public static Node addTwo(Node first,Node second){
        Node f = first;
        Node s =second;
        Node cur = new Node(0);
        Node dummy = new Node(0);
        dummy.next=cur;
        int carry=0;
        while (f!=null||s!=null){
            int a ,b;
            a= (f==null?0:f.value);
            b=(s==null?0:s.value);
            cur.value=(a+b)%10+carry;
            carry=cur.value/10;
            cur=cur.next;
            f=f.next;
            s=s.next;

        }
        cur.value=(carry==0?null:1);

        return dummy.next;
    }
}
