package com.bala.zigzag;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
    请你实现这个将字符串进行指定行数变换的函数：
    string convert(string s, int numRows);
     */
    public static String zigZagconvert(String s,int numRows){
        StringBuilder[] sb = new StringBuilder[numRows];//每一行创建一个StringBuilder
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i=0;
        while (i < s.length()){
            for (int j = 0; j < numRows; j++) { //按s的顺序用StringBuilder添加，一个'V'是一个循环
                if (i<s.length()) {
                    sb[j].append(s.charAt(i));
                    i++;
                }
                else break;
            }
            for (int k = numRows-2; k > 0 ; k--) {
                if (i<s.length()) {
                    sb[k].append(s.charAt(i));
                    i++;
                }
                else break;
            }
        }
        //最后将按行拼接
        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb1.append(sb[j]);
        }

        return sb1.toString();
    }

    /*
    leetcode 解法，思路和上面大同小异
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


}
