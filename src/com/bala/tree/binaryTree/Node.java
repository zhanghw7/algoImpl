package com.bala.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node leftNode;
    private Node rightNode;
    private Object value;


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void add(Object v){
        if (this.value==null)
            this.value=v;
        else {
            if ((Integer) v <= (Integer) value) {
                if (leftNode == null)
                    leftNode = new Node();
                leftNode.add(v);

            } else {
                if (rightNode == null)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }

    /*
    中序遍历
     */
    public List getSortedNode(){
        List list = new ArrayList();
        if (leftNode!=null)
            list.addAll(leftNode.getSortedNode());

        list.add(this.value);

        if (rightNode!=null)
            list.addAll(rightNode.getSortedNode());

        return list;
    }

}
