package com.bala.reverseString;

import java.util.Iterator;
import java.util.Stack;

public class ReverseStr {
    /*
        将String按单词reverse
     */
    public static void reverseStringBySingleWord(String s){
        Stack<String> strings = new Stack<>();
        int i =0;
        while (i<s.length()){
            if (s.charAt(i)==' '){
                strings.push(" ");
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(i<s.length()&&' '!=s.charAt(i)){
                sb.append(s.charAt(i));
                i++;
            }
            strings.push(sb.toString());
        }
        //Iterator iterator = strings.iterator();
        while (!strings.empty()){
            System.out.print(strings.pop());
        }
    }

    public static void main(String[] args) {
        String s = "hello world, haha ";
        reverseStringBySingleWord(s);
    }
}
