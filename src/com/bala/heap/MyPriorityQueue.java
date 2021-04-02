package com.bala.heap;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 实现PriorityQueue,按Comparable排序时默认为最小堆
 * @Author Zhang Hongwei
 * @Date 2021/4/1 11:25
 */
public class MyPriorityQueue<E> extends AbstractQueue<E>{
    private Object[] queue;
    private int size;//queue中元素的数量

    private final Comparator<? super E> comparator;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    public MyPriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public MyPriorityQueue(Comparator<Object> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public MyPriorityQueue(int initialCapacity, Comparator<Object> comparator) {
        this.comparator = comparator;
        queue = new Object[initialCapacity];
    }

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
    public boolean offer(E o) {
        if (size == queue.length) grow();
        queue[size] = o;
        if (comparator == null) {
            swapUp(size);
        } else {
            swapUpWithComparator(size);
        }
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E poll() {
        if (size == 0){
            return null;
        }
        swap(0, --size);
        swapDown(0);
        return (E) queue[size];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        return (E) queue[0];
    }

    //将位于这个index的值向上swap，直到满足heap特性, 有comparator的情况
    private void swapUpWithComparator(int i){
        while (i > 0){
            int p = (i - 1) >>> 1;
            if (comparator.compare((E) queue[i], (E) queue[p]) < 0){
                swap(i, p);
                i = p;
            }else {
                break;
            }
        }
    }

    //当元素实现了Comparable接口的时候
    private void swapUp(int i){
        while (i > 0){
            int p = (i - 1) >>> 1;
            Comparable<E> child = (Comparable<E>) queue[i];
            if (child.compareTo((E) queue[p]) < 0){
                swap(i, p);
                i = p;
            }else {
                break;
            }
        }
    }

    private void swapDown(int i){
        while (i < size){
            Comparable<E> p = (Comparable<E>) queue[i];
            int c = min(i * 2 + 1, i * 2 + 2);//找出较小的子节点
            if (c != -1 && p.compareTo((E) queue[c]) > 0){
                swap(i, c);
                i = c;
            }else {
                break;
            }
        }
    }

    private void swap(int a, int b){
        Object temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }

    //比较两个节点的元素的大小
    private int min(int a, int b){
        if (a < size && b < size){
            Comparable<E> ca = (Comparable<E>) queue[a];
            return  ca.compareTo((E) queue[b]) < 0 ? a : b;
        }else if(b < size){
            return b;
        }else if (a < size){
            return a;
        }else {
            return -1;
        }
    }
}
