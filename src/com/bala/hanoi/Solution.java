package com.bala.hanoi;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    private static int  hanoi(int n, char A, char B, char C, int count){
        if(n==1){
            System.out.println(A+" -> "+C);
            count++;
            return count;
        }
        else {
           count = hanoi(n-1, A, C, B, count);
            System.out.println(A+" -> "+C);
            count++;
           count = hanoi(n-1, B, A, C, count);
        }
        return count;
    }

    public static void main(String[] args) {



    }
    public int hash(String s){
        if(s.length()==0) return 0;
        int hash = 0;
        char[] value = s.toCharArray();
        for (char c : value) {
            hash = hash + 17 * c;
        }
        return hash;
    }
}
