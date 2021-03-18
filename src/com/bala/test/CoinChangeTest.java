package com.bala.test;

import org.junit.Test;

import java.util.Arrays;

public class CoinChangeTest {
    @Test
    public void test01(){


    }

    public String compressString(String S) {
        String result = "";
        int i = 0;
        while(i < S.length()){
            char cur = S.charAt(i);
            int count = 0;
            while(i<S.length()&&S.charAt(i)==cur){
                count++;
                i++;
            }
            result+=cur+count;
            if(result.length() > S.length()){
                return S;
            }
        }
        return result;
    }
}
