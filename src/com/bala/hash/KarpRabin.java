package com.bala.hash;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Description karp-rabin 字符串匹配算法, 假定字符串全由ascii码组成
 * @Author Zhang Hongwei
 * @Date 2021/9/5 9:25
 */
public class KarpRabin {
    /**
     * 判断字符串s中是否存在字符串t
     */
    public static boolean isExisted(String s, String t){
        if (s == null ||t == null || s.length() < t.length()){
            return false;
        }
        RollingHasher rs = new RollingHasher(t.length());
        RollingHasher rt = new RollingHasher(t.length());
        for (int i = 0; i < t.length(); i++) {
            rt.append(t.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            rs.append(s.charAt(i));
        }
        if (rs.hash == rt.hash && isEqual(t, s, 0)){
            return true;
        }
        for (int i = t.length(); i < s.length(); i++) {
            rs.skip();
            rs.append(s.charAt(i));
            if (rs.hash == rt.hash && isEqual(t, s, i - t.length() + 1)){
                return true;
            }
        }
        return false;
    }

    public static boolean isEqual(String t, String s, int startIndex){
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != s.charAt(startIndex + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*boolean existed = isExisted("qwerfvdvxzcvzxt", "qwer");
        System.out.println(existed);*/
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        long l = prime.longValue();
        System.out.println(l);
    }

    static class RollingHasher{
        int lengthOfTargetString;
        int hash;
        int basePower = 1; //base的n-1次方mod prime, n为字符传的长度
        final int BASE = 128;
        final int PRIME = 499;
        LinkedList<Character> chars = new LinkedList<>();

        public RollingHasher(int lengthOfTargetString) {
            this.lengthOfTargetString = lengthOfTargetString;
            for (int i = 0; i < lengthOfTargetString - 1; i++) {
                basePower = basePower * BASE % PRIME;
            }
        }

        public void append(char c){
            hash = (hash * BASE + c) % PRIME;
            chars.addLast(c);
        }

        public void skip(){
            hash = (hash + PRIME - basePower * chars.get(0) % PRIME) % PRIME;
            chars.removeFirst();
        }
    }
}
