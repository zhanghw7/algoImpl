package com.bala.heap;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @Author Zhang Hongwei
 * @Date 2021/4/1 11:25
 */
public class MyPriorityQueue<E> extends AbstractQueue<E>{
    private Object[] queue;
    private int size;//queue中元素的数量

    private Comparator<E> comparator;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    //扩大queue.length
    public void grow(){
        if (queue.length >= MAX_ARRAY_SIZE){
            throw new OutOfMemoryError();
        }
        int newLength = queue.length < Integer.MAX_VALUE / 2 ? queue.length * 2 : MAX_ARRAY_SIZE;
        queue = Arrays.copyOf(queue, newLength);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

}
