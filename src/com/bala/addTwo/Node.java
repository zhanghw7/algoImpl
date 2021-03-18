package com.bala.addTwo;

public class Node {
    int value;
    Node next;
    public Node(int value,Node next){
        this.next= next;
        this.value=value;
    }
    public Node(int value){
        this.value = value;
    }


    public static void main(String[] args) {
        Node node = new Node(0);
        System.out.println(node.next.next);

        String s = "we";
        System.out.println();
    }
}
