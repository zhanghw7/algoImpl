package com.bala.test;

import com.bala.tree.binaryTree.AVLTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");

        for (String v : map.values()) {
            System.out.println(v);
        }
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : deck){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        int count = 0;
        for(int v : map.values()){
            int curGcd = gcd(v, count);
            if(curGcd == 1){
                return false;
            }else{
                count = curGcd;
            }
        }
        return true;
    }

    public int gcd(int a, int b){
        int s = Math.min(a, b);
        int g = Math.max(a, b);
        if(s == 0){
            return g;
        }else{
            return gcd(s, g % s);
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, 0, words.length, (o1, o2) -> o2.length() - o1.length());
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (i == 0 || (!s.equals(words[i - 1]) && !sb.toString().contains(s)&&sb.charAt(sb.indexOf(s)+s.length())=='#')) {
                sb.append(s).append("#");
            }
        }
        return sb.toString().length();
    }
    public int lastRemaining(int n, int m){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i =0;i < n;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = dummy.next;
        while(cur.val != cur.next.val){
            int count = 0;
            while(++count < m){
                cur = cur.next;
            }
            System.out.println(cur.next.val);
            cur.next = cur.next.next;
        }
        return cur.val;
    }
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    @Test
    public void testLastRemaining(){
        System.out.println(lastRemaining(5, 3));
    }
}
